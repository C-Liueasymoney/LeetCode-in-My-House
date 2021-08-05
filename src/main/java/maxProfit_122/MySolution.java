package maxProfit_122;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/30 5:09 下午
 */
public class MySolution {
    public int maxProfit(int[] prices) {
        return process(prices, 0, 0, 0);
    }

    /**
     * 整体思路就是自底向上的去返回收益，
     * 当我此时手上没有股票的时候，我可以有两种选择：买或者不买，也就对应着下一天的两种状态：手上有或者没有股票（可能买入了）
     * 此时手上有股票的时候，也是有两种选择：卖或者不卖，对应下一天两种状态：手上有或者没有股票（可能卖掉了）
     * 根据每一天的状态（status==0/1）,来向上返回做出两种选择下的最大收益
     * @param prices
     * @param index 当前天数
     * @param stock 手上持有的股票
     * @param status 0表示没持有股票，1表示持有
     * @return
     */
    public int process(int[] prices,int index, int stock, int status){
        if (index >= prices.length)
            return 0;

        // 记录买或者不买(卖或者不卖)两中情况下的收益
        int p1 = 0;
        int p2 = 0;

        if (status == 0){  // 当前手上没有股票，也就无法卖出;只有选择买或者不买
            p1 = process(prices, index + 1, prices[index], 1);
            p2 = process(prices, index + 1, 0, 0);
            return Math.max(p1, p2);
        }else {   // 此时手里有股票，可以选择卖或者不买（但是不能再买入了）
            p1 = process(prices, index + 1, 0, 0) + (prices[index] - stock);   // 卖
            p2 = process(prices, index + 1, stock, 1);
            return Math.max(p1, p2);
        }
    }


    @Test
    public void test(){
        int[] nums = {7,6,4,3,1};
        int res = maxProfit(nums);
        System.out.println(res);
    }
}
