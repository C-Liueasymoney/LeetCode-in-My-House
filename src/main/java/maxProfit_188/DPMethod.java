package maxProfit_188;

import org.junit.Test;

import java.security.PrivateKey;

/**
 * @Description: 股票买卖4
 * 动态规划解法
 * @Author: chong
 * @Data: 2021/7/30 10:06 下午
 */
public class DPMethod {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        // 1、这道题的暴力递归使用了三个可变参数（stock不算），多了一个k表示交易次数，那么需要三维dp数组
        // 另外dp中保存的是当前收益
        int[][][] dp = new int[prices.length][k + 1][2];      // 分别是index（天数）、k（所剩交易次数）、status（持股状态）

        // 2、分析初始状态，index=0时，status=0说明没买，status=1说明买了，此时除了k=0都初始化为-prices[0]
        // dp[0][k][0] = 0, dp[0][k][1] = -prices[0]  (k > 0)
        for (int i = 1; i <= k; i++){
            dp[0][i][1] = -prices[0];
        }

        // 3、思考状态转移方程
        // dp[index][k][1] = Max(dp[i - 1][k - 1][0] - prices[index], dp[i - 1][k][1]) 完全可以从递归关系得到
        // dp[index][k][0] = Max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[index])

        // 4、根据转移方程得到遍历顺序
        for (int index = 1; index < prices.length; index++){
            for (int kVal = 1; kVal <= k; kVal++){
                dp[index][kVal][1] = Math.max(dp[index - 1][kVal - 1][0] - prices[index],
                        dp[index - 1][kVal][1]);
                dp[index][kVal][0] = Math.max(dp[index - 1][kVal][0],
                        dp[index - 1][kVal][1] + prices[index]);
            }
        }

        // 5、最后返回结果应该是dp[prices.length - 1][k][0]，表示最后一天，最多允许 K 次交易，最多获得多少利润
        return dp[prices.length - 1][k][0];
    }

    @Test
    public void test(){
        int[] prices = {1,2};
        int res = maxProfit(1, prices);
        System.out.println(res);
    }

}
