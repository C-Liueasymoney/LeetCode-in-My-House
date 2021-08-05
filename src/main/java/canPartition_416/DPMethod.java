package canPartition_416;

import java.lang.annotation.Target;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/21 10:13 下午
 */
public class DPMethod {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];   // 两个可变参数，二维
        // 这里根据具体情况，看出dp[0][0]位置是false，因为在nums[0]位置的值大于0，无法得到target=0,false不用初始化
        // 而且，在index=0时，由于只选择了nums[0]一个值，如果这个值等于target，这一格就为true,第一行其他格子都是false
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        // 这里和递归方法不同的是，递归方法是自上而下的，而dp是自下而上，因此依赖方向相反
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                // 每行要依赖上一行的结果，因为index要看index-1行是不是能完成target
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j){
                    dp[i][j] =true;
                }

                if (nums[i] < j){  // index的值比target小，那要分析之前的值
                    // 考虑两种情况：1、不使用num[i]作为子集，2、使用
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
