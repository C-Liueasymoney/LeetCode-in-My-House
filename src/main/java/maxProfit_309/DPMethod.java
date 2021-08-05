package maxProfit_309;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/19 11:43 下午
 */
public class DPMethod {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int num : prices){  // 求数组中最大值，确定一下缓存大小,因为数组列存的是stock，所以要直到prices中的最大值
            max = Math.max(max, num);
        }
        // 两个可变参数，一个二维数组，行：index，列：stock
        int[][] dp = new int[prices.length][max + 2];  // stock范围0～max，还要额外存个-1做标志位，数组中就放在dp[i][max + 1]表示了
        // 确定初始值，index=0时无法卖出，所以一行都是0
        for (int i = 0; i < dp[0].length; i++){    // 没实际意义，因为初始数组就是0，就是表示一下
            dp[0][i] = 0;
        }
        int res = 0;    // 存结果

        //TODO 待完成
        return 0;
    }
}
