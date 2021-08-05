package maxProfit_309;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/7/19 11:04 下午
 */
public class MySolution {
    public int maxProfit(int[] prices) {
        return process(prices, 0, -1);
    }

    public int process(int[] prices, int index, int stock){
        if (index >= prices.length){   // base case
            return 0;
        }

        int p1 = 0;   // p1和p2分别表示选择买入（卖出）或者不买入（不卖出）的情况下获得的最大利润
        int p2 = 0;
        if (stock == -1){   // 表示此时手中没有股票，可以选择买入
            p1 = process(prices, index + 1, prices[index]);  // 选择买入，此时手上的股票stock为买入时价格
            p2 = process(prices, index + 1, -1);     // 选择不买，此时stock=-1表示手上没有股票
        }else {  // stock != -1,表示此时手上有股票
            if (prices[index] > stock){   // 当前股票价格大于手上股票的价格才有必要考虑卖出
                // 选择卖出，由于冷冻期，所以要跳过下一天，index直接+2；另外要把差价统计进p1中
                p1 = process(prices, index + 2, -1) + (prices[index] - stock);
            }
            p2 = process(prices, index + 1, stock);   // 无论差价是否为负数，都可以选择不卖
        }

        return Math.max(p1, p2);    // 返回两种情况的最大值
    }


    @Test
    public void test(){
        int[] prices = {1, 2, 3, 0, 2};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
