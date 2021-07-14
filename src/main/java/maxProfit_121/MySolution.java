package maxProfit_121;


import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/24 9:13 上午
 */
public class MySolution {
    public int maxProfit(int[] prices){
        if (prices.length <= 1)
            return 0;
        int left = 0;
        int right = 1;
        int res = 0;
        while (right < prices.length){
            if (prices[left] < prices[right])
                res = Math.max(res, prices[right] - prices[left]);
            else
                left = right;
            right++;
        }
        return res;
    }

    @Test
    public void test(){
        int[] prices = {7,6,4,3,1};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
