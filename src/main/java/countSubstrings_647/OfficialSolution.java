package countSubstrings_647;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/13 8:05 下午
 */
public class OfficialSolution {
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            res++;
        }

        for (int L = 2; L <= s.length(); L++){
            for (int i = 0; i < s.length(); i++){
                int j = L + i - 1;
                if (j >= s.length())
                    break;
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (L <= 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j])
                    res++;
            }
        }
        return res;
    }
}
