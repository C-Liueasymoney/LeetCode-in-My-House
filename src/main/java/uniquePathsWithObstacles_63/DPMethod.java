package uniquePathsWithObstacles_63;

/**
 * @Description:
 * 改成动态规划
 * @Author: chong
 * @Data: 2021/8/10 7:39 下午
 */
public class DPMethod {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 注意有障碍物的限制
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                int a = 0;
                int b = 0;
                if (obstacleGrid[i][j] == 0){
                    if (i != 0){
                        a = dp[i - 1][j];
                    }
                    if (j != 0){
                        b = dp[i][j - 1];
                    }
                    if (i != 0 || j != 0){  // 不去赋值dp[0][0]
                        dp[i][j] = a + b;
                    }
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
