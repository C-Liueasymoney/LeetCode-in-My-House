package MedianFinder_295;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/2 9:59 上午
 */
public class MySolution {

    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MySolution(){
        minQueue = new PriorityQueue<>((a, b) -> a - b);
        maxQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxQueue.size() == 0) {
            maxQueue.offer(num);
            return;
        }
        if (num <= maxQueue.peek()){
            maxQueue.add(num);
        }else {
            if (minQueue.isEmpty()){
                minQueue.add(num);
                return;
            }
            if (minQueue.peek() > num)
                maxQueue.add(num);
            else
                minQueue.add(num);
        }
        modifyTwoHeapSize();
    }

    public double findMedian() {
        int maxSize = maxQueue.size();
        int minSize = minQueue.size();
        if (maxSize + minSize == 0)
            return 0;

        Integer maxHead = maxQueue.peek();
        Integer minHead = minQueue.peek();

        if (((maxSize + minSize) & 1) == 0){
            return (double) ((maxHead + minHead)) / 2;
        }
        return maxSize > minSize ? maxHead : minHead;
    }

    public void modifyTwoHeapSize(){
        if (maxQueue.size() - minQueue.size() >= 2)
            minQueue.add(maxQueue.poll());
        if (minQueue.size() - maxQueue.size() >= 2)
            maxQueue.add(maxQueue.poll());
    }

    @Test
    public void test(){
        MySolution mySolution = new MySolution();
        mySolution.addNum(1);
        mySolution.addNum(2);
        double median = mySolution.findMedian();
        System.out.println(median);
    }
}
