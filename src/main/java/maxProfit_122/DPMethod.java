package maxProfit_122;

import org.junit.Test;

/**
 * @Description:
 * DP方法主要也是根据暴力递归来改造，但是由于DP是自上而下，所以需要从递归方法的下一层去向上考虑
 * @Author: chong
 * @Data: 2021/7/30 6:07 下午
 */
public class DPMethod {
    public int maxProfit(int[] prices) {
        // 1、这里递归方法中有3个可变参数index、stock、status，但是只选择两个作为dp数组的维度即可：index、status
        // 因为这里在dp中保存的其实是我们获得的收益（会有负数，因为可能会买入了没卖出或者买入价格高于卖出价格），也就代表了stock
        // 实际上递归方法中也就只有index和status两个参数代表着两个状态来影响结果，stock只是保存一些中间值，我们可以代替掉它

        int[][] dp = new int[prices.length][2];

        // 2、思考一下初始条件，在index=0时，也就是第一天，如果没买入（status=0）手里的钱就是0
        // 如果买入了（status=1），那么手里的钱就是-price[0]，即花了这么多钱，此时收益是负数

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 3、接下来来考虑一下每个位置是如何依赖其他位置的，也就是状态转移方程，这里对比下面的递归方法调用来解释
        //  再次强调DP方法是自上而下的，因此对于自下而上的递归掉用，需要看到其逆过程，也就是说假如当前天数index下status=0时，
        // 在递归方法中应该对应的是：第3行和第6行
        //                        p2 = process(prices, index + 1, 0, 0);  和
        //                        p1 = process(prices, index + 1, 0, 0) + (prices[index] - stock);   // 卖
        // 原因就是这两个递归调用中，传入的status值是0，也就是说，在dp中我们在当前天status=0时要看前一天的结果，那么在递归中就看下一天
        // status=0的情况下，当前天都做了什么
        // 解释清楚这一点，就可以推导状态转移方程了：根据status两个状态，分别产生两种选择，在其中选择较大者记录在dp数组中
        // （1）当天status=0时（当前天手上无股票），对应3、6行，依赖的是前一天index-1的status=0和1；status=0时，表示前一天手上没股票，
        //  那么导致今天手上没股票原因就是今天没买入，也就是第3行的stock参数传入0；
        //  status=1时，对应6行，此时前一天手上是有股票的，到了今天就没了，那说明今天把股票卖了，对应6行后面的prices[index] - stock
        //  因此得到转移方程：dp[i][0] = Max( dp[i - 1][0] , dp[i - 1][1] + prices[index])
        //  (2) 当天status=1时（手上有股票），对应2、7行。前一天status=0时，说明今天买了股票；前一天status=1时，说明今天没卖掉股票
        //  状态转移：dp[i][1] = Max( dp[i - 1][0] - prices[index] , dp[i - 1][1])


        // 4、那么根据上面的依赖方向，就得到了遍历顺序应该是从上到下，从左向右
        for (int index = 1; index < dp.length; index++){
            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1] + prices[index]);
            dp[index][1] = Math.max(dp[index - 1][0] - prices[index], dp[index - 1][1]);
        }

        // 5、最后返回结果应该是最后一天，手里没股票的情况即dp[prices.length - 1][0]
        return dp[prices.length -1][0];
    }

    @Test
    public void test(){
        int[] nums = {7,1,5,3,6,4};
        int res = maxProfit(nums);
        System.out.println(res);
    }
}

/*
1        if (status == 0){  // 当前手上没有股票，也就无法卖出;只有选择买或者不买
2            p1 = process(prices, index + 1, prices[index], 1);
3            p2 = process(prices, index + 1, 0, 0);
4            return Math.max(p1, p2);
5        }else {   // 此时手里有股票，可以选择卖或者不买（但是不能再买入了）
6            p1 = process(prices, index + 1, 0, 0) + (prices[index] - stock);   // 卖
7            p2 = process(prices, index + 1, stock, 1);
8            return Math.max(p1, p2);
        }
 */

/*
最后给出[7,1,5,3,6,4]情况下的dp表：
         \status
          \  0       1
    index \-------------
        0 |   0  |  -7  |
          ---------------
        1 |   0  |  -1  |
          --------------
        2 |   4  |  -1  |
           -------------
        3 |   4  |   1  |
           -------------
        4 |   7  |   1  |
          --------------
        5 |   7  |   3  |

 */