package rob_213;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/15 10:14 下午
 */
public class MySolution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(robProcess(Arrays.copyOfRange(nums, 1, nums.length)),
                robProcess(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int robProcess(int[] nums){
        int pre = 0;
        int cur = 0;
        int temp = 0;
        for (int num : nums){
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }
}
