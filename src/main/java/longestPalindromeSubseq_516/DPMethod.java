package longestPalindromeSubseq_516;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/12 8:53 下午
 */
public class DPMethod {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // 往外扩散
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = 1;   // 初始化
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[s.length() - 1][0];
    }

    @Test
    public void test() {
        int res = longestPalindromeSubseq("bbbab");
        System.out.println(res);
    }
}
