package rob_198;

import org.junit.Test;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/15 4:56 下午
 */
public class MySolution {
    public int rob(int[] nums) {
        // nums的长度小于等于2的情况都可以直接获得最大利润
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // 最大利润
        int maxValue = 0;

        // n * 2的dp数组，代表每个屋子的偷与不偷的两种情况下，到该屋子能获得的最大利润
        int[][] dp = new int[nums.length][2];
        // 下标0表示不偷，1表示偷
        dp[0] = new int[]{0, nums[0]};       // 第一间屋子可以直接确定，不偷情况下利润为0，偷情况下利润为nums[00
        dp[1] = new int[]{dp[0][1], dp[0][0] + nums[1]};      // 第二间屋子也可以确定，不偷利润是第一间偷的利润，偷是nums[1]+第一间不偷

        // 但是注意从第三间屋子开始，情况发生变化，当前屋子偷情况下的利润依然是nums[i] + 上一间屋子不偷
        // 但是如果是当前屋子决定不偷，那么不仅仅只考虑上一间屋子，还要考虑再上一间屋子的情况，因为当前不偷，上一间屋子可以偷，
        // 但如果上一间屋子偷了，再上一间就不能偷了。那如果再上一间偷的利润比上一间大，就亏了，所以要在二者之间选择一个更大的
        for (int i = 2; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
            maxValue = Math.max(maxValue, Math.max(dp[i][0], dp[i][1]));
        }

        return maxValue;
    }

    @Test
    public void test(){
        int[] nums = {2, 7, 9, 3, 1};
        int res = rob(nums);
        System.out.println(res);
    }
}
