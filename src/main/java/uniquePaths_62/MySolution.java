package uniquePaths_62;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/17 9:06 上午
 */
public class MySolution {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int a = 0;
                int b = 0;
                if (i > 0)
                    a = dp[i - 1][j];
                if (j > 0)
                    b = dp[i][j - 1];
                if (i > 0 || j > 0)
                    dp[i][j] = a + b;
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test(){
        int res = uniquePaths(13, 17);

        System.out.println(res);
    }
}
