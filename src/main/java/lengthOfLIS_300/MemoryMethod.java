package lengthOfLIS_300;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/19 6:14 下午
 */
public class MemoryMethod {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res = Math.max(process(nums, i, dp), res);
        }
        return res;
    }

    public int process(int[] nums, int index, int[] dp){
        if (index == nums.length){
            return 0;
        }
        if (dp[index] != 0){
            return dp[index];
        }

        int max = 0;
        for (int i = index + 1; i < nums.length; i++){
            int temp = 0;
            if (nums[i] > nums[index]){
                temp = process(nums, i, dp);
                max = Math.max(temp, max);
            }
        }
        dp[index] = max + 1;

        return dp[index];
    }

    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
