package lengthOfLIS_300;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/19 6:23 下午
 */
public class DPMethod {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;

        // 根据base case确定初始条件
        dp[nums.length - 1] = 1;   // 表示nums最后一位最大子序列长度为1
        // 根据递归关系和初始条件确定遍历顺序是从右到左
        for (int index = nums.length - 2; index >= 0; index--){

            int max = 0;
            for (int i = index + 1; i < dp.length; i++){
                int temp = 0;
                if (nums[i] > nums[index]){
                    temp = dp[i];
                    max = Math.max(temp, max);
                }
            }
            dp[index] = max + 1;

            res = Math.max(dp[index], res);
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
