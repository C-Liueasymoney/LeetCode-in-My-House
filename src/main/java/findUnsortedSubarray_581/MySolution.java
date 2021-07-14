package findUnsortedSubarray_581;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/6 3:34 下午
 */
public class MySolution {
    public int find(int[] nums){
        if (nums.length < 2)
            return 0;

        LinkedList<Integer> stack = new LinkedList<>();
        int left = nums.length;
        int right = 0;
        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && stack.peek() > nums[i]){
                stack.pop();
                left = Math.min(left, stack.size());
            }
            stack.push(nums[i]);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                stack.pop();
                right = Math.max(right, nums.length - 1 - stack.size());
            }
            stack.push(nums[i]);
        }

        return left < right ? right - left + 1 : 0;
    }


    @Test
    public void test(){
        int[] nums = {1, 3, 2, 3, 3};
        int res = find(nums);
        System.out.println(res);
    }
}
