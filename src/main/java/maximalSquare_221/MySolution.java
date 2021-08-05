package maximalSquare_221;

import org.junit.Test;

import java.rmi.MarshalledObject;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/16 6:06 下午
 */
public class MySolution {
    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i - 1 >= 0 && j - 1 >= 0){
                    if (matrix[i][j] == '1'){
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        result = Math.max(result, dp[i][j]);
                        continue;
                    }
                }
                dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }

    @Test
    public void test(){
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = maximalSquare(matrix);
        System.out.println(res);
    }
}
