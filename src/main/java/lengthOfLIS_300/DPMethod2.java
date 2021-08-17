package lengthOfLIS_300;

/**
 * @Description:
 * 这个是自顶而下的dp
 * @Author: chong
 * @Data: 2021/8/8 2:00 下午
 */
public class DPMethod2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (nums[j] <= nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
