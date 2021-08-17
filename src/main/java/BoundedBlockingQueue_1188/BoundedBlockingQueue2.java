package BoundedBlockingQueue_1188;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/8 9:22 下午
 */
public class BoundedBlockingQueue2 {
    private Deque<Integer> deque = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private AtomicInteger size = new AtomicInteger();
    private final int capacity;


    public BoundedBlockingQueue2(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        int count = -1;
        lock.lock();
        try {
            while (size.get() == capacity){
                notFull.await();
            }

            deque.offer(element);
            count = size.getAndIncrement();
            if (count < capacity){
                notEmpty.signal();
            }
        }finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        int count = -1;
        int result = 0;
        lock.lock();
        try {
            while (size.get() == 0){
                notEmpty.await();
            }

            result = deque.poll();
            count = size.getAndDecrement();
            if (count > 0){
                notFull.signal();
            }

            return result;
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        return size.get();
    }


    public static void main(String[] args) {
        BoundedBlockingQueue2 blockingQueue = new BoundedBlockingQueue2(2);

        for (int i = 0; i < 5; i++){
            int j = i;
            new Thread(() -> {
                try {
                    blockingQueue.enqueue(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true){
                int res = 0;
                System.out.println("阻塞队列大小：" + blockingQueue.size());
                try {
                    res = blockingQueue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(res);
            }
        }, "消费者").start();

    }
}
