package longestValidParentheses_32;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 3:46 下午
 */
public class MySolution {
    public int longestValidParentheses(String s){
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        int result = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '(')
                dp[i] = 0;
            else {
                if (s.charAt(i - 1) == '('){
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                }else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = i - dp[i - 1] - 2 >=0? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] : dp[i - 1] + 2;
                    }else
                        dp[i] = 0;
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    @Test
    public void test(){
        int res = longestValidParentheses("(()())");
        System.out.println(res);
    }
}
