package maxSlidingWindow_239;

import org.junit.Test;
import sun.security.provider.ConfigFile;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/13 4:24 下午
 */
public class MySolution {
    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> deque = new LinkedList<>();

        // 由于数组长度为n，产生的结果长度肯定是n - k + 1
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length){
            // 先让窗口扩充到k大小，left才开始移动
            if (right >= k){
                // 检查此时队列的头节点（下标）是否等于left，如果是说明它要被移动到窗口外了，就把它从队列里删掉
                if (deque.getFirst() == left)
                    deque.removeFirst();
                // 不等于就什么都不做，left++
                left++;
            }

            // 对于新加入的元素，要保证队列的单调性，就要把新元素前面比其小的都干掉
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[right]){
                deque.removeLast();
            }
            deque.addLast(right);

            // 得到当前滑动窗口中最大值（从窗口大小达到k再开始记录）
            if (right >= k - 1){
                res[index++] = nums[deque.getFirst()];
            }
            right++;
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = {1, -1};
        int[] res = maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(res));
    }
}
