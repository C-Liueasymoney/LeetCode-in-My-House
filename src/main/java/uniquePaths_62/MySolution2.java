package uniquePaths_62;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/10 7:57 下午
 */
public class MySolution2 {
    public int uniquePaths(int m, int n){
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int a = 0;
                int b = 0;
                if (i != 0){
                    a = dp[j];
                }
                if (j != 0){
                    b = dp[j - 1];
                }
                if (i != 0 || j != 0){
                    dp[j] = a + b;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
