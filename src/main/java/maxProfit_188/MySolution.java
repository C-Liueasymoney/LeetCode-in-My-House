package maxProfit_188;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/30 9:46 下午
 */
public class MySolution {
    int kCap;
    public int maxProfit(int k, int[] prices) {
        kCap = k;
        return process(prices, 0, 0, 0, 0);
    }


    /**
     *
     * @param prices
     * @param index 天数
     * @param k 当前已经交易数
     * @param stock 当前手中持有股票的价格
     * @param status 股票持有状态（0代表没有股票，1代表有股票）
     * @return
     */
    public int process(int[] prices, int index, int k, int stock, int status){
        if (index >= prices.length || k > kCap)  // 到了最后一天，或者没有交易次数了都应该返回(注意k=0时还可以卖出)
            return 0;

        if (status == 0){
            return Math.max(process(prices, index + 1, k + 1, prices[index], 1),  // 买入
                    process(prices, index + 1, k, 0, 0));   // 不买
        }else{
            return Math.max(process(prices, index + 1, k, 0, 0) + (prices[index] - stock),  // 卖了
                    process(prices, index + 1, k, stock, 1));    // 不卖
        }
    }

    @Test
    public void test(){
        int[] prices = {3,2,6,5,0,3};
        int res = maxProfit(2, prices);
        System.out.println(res);
    }
}
