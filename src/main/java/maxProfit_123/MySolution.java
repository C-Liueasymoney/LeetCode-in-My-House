package maxProfit_123;

import org.junit.Test;

/**
 * @Description:
 * 对应股票买卖k=2的情况，暴力递归
 * @Author: chong
 * @Data: 2021/8/1 9:37 上午
 */
public class MySolution {
    public int maxProfit(int[] prices) {
        return process(prices, 0, 0, 0, 0);
    }

    public int process(int[] prices, int index, int k, int stock, int status){
        if (index > prices.length - 1 || k > 2)  // base case
            return 0;

        if (status == 0){ // 手里没有股票
            return Math.max(process(prices, index + 1, k + 1, prices[index], 1),  // 买入
                    process(prices, index + 1, k, 0, 0));
        }else {
            return Math.max(process(prices, index + 1, k, 0, 0) + (prices[index] - stock), // 卖出
                    process(prices, index + 1, k, stock, 1));
        }
    }

    @Test
    public void test(){
        int[] prices = {1};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
