package maxProfit_123;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/1 9:46 上午
 */
public class DPMethod {
    public int maxProfit(int[] prices) {
        // 1、确定维度,可变参数：index、k、status
        int[][][] dp = new int[prices.length][3][2];
        // 2、分析初始状态：k != 0时，index=0、status=1处都为-prices[index]
        for (int i = 1; i < 3; i++){
            dp[0][i][1] = -prices[0];
        }
        // 3、分析依赖关系，直接从递归调用得到，并且遍历方式也可以得出
        for (int index = 1; index < prices.length; index++){
            for (int kVal = 1; kVal < 3; kVal++){
                dp[index][kVal][0] = Math.max(dp[index - 1][kVal][0], dp[index - 1][kVal][1] + prices[index]);
                dp[index][kVal][1] = Math.max(dp[index - 1][kVal - 1][0] - prices[index], dp[index - 1][kVal][1]);
            }
        }
        // 4、返回的应该是最后一天，交易次数达到最大，手中没有股票的情况
        return dp[prices.length - 1][2][0];
    }

    @Test
    public void test(){
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
