package numTrees_96;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/22 9:48 上午
 */
public class MySolution {
    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        int res = numTrees(5);
        System.out.println(res);
    }
}
