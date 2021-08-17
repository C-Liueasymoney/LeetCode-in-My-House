package longestCommonSubsequence_1143;

import org.junit.Test;
import sun.jvm.hotspot.debugger.Page;

/**
 * @Description:
 * 改成动态规划
 * @Author: chong
 * @Data: 2021/8/12 6:27 下午
 */
public class DPMethod {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 依赖关系肯定是从上到下，从左到右；并且需要去判断两种不同的情况
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    @Test
    public void test() {
        int res = longestCommonSubsequence("abc", "abc");
        System.out.println(res);
    }
}
