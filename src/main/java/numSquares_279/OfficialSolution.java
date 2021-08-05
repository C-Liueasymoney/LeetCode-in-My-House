package numSquares_279;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/18 5:27 下午
 */
public class OfficialSolution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
