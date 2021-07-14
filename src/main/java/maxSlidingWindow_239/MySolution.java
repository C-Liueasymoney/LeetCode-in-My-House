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

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if (right >= k){
                if (deque.getFirst() == left)
                    deque.removeFirst();
                left++;
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[right]){
                deque.removeLast();
            }
            deque.addLast(right);

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
