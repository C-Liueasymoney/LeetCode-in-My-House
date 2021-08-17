package numDecodings_91;

import org.junit.Test;

/**
 * @Description:
 * 动态规划
 * 这道题从暴力递归转化要耗费一点思考，主要是递归中还有一个循环，但记住下面的原则就好处理了
 * 以本题为例，循环中最多只会循环两次，传入下层递归的是：index+1和index+2，
 * 那么我们反过来看，在当前点我们依赖哪层递归呢，显然是index-1和index-2。
 * 所以反映到动态规划中的状态转移方程就是：dp[i]=dp[i-1] + dp[i-2]，也就是依赖关系
 * 别忘记在递归中还有一个判断就是s.charAt(index)=0的话，我们就跳过本次循环，并且num大于0小于等于26才进入下层递归
 * @Author: chong
 * @Data: 2021/8/15 3:26 下午
 */
public class DPMethod {
    public int numDecodings(String s) {
        // dp[i]代表0～i的子串有几种编码种数
        int[] dp = new int[s.length()];
        if (s.charAt(0) != '0'){
            dp[0] = 1;
        }

        for (int i = 1; i < dp.length; i++){
            int index = Math.max(0, i - 2);
            if (s.charAt(i) == '0'){
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2'){
                    dp[i] = dp[index];
                }
            }else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')){
                dp[i] = dp[i - 1] + dp[index];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    @Test
    public void test() {
        int res = numDecodings("226");
        System.out.println(res);
    }
}
