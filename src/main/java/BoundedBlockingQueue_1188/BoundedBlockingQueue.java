package BoundedBlockingQueue_1188;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/4 1:56 下午
 */
public class BoundedBlockingQueue {

    private final int capacity;
    private final LinkedList<Integer> queue = new LinkedList<>();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (queue){
            while (queue.size() == capacity){
                System.out.println("队列满，请等待");
                queue.wait();
            }
            queue.addFirst(element);
            queue.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                System.out.println("队列空，请等待");
                queue.wait();
            }
            int result = queue.removeLast();
            queue.notify();
            return result;
        }
    }

    public int size() {
        return queue.size();
    }


    public static void main(String[] args) {
        BoundedBlockingQueue blockingQueue = new BoundedBlockingQueue(2);

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
