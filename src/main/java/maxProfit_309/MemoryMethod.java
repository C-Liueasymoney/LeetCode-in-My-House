package maxProfit_309;

import org.junit.Test;

import java.net.DatagramPacket;
import java.nio.file.StandardWatchEventKinds;

/**
 * @Description:
 * 记忆化搜索
 * @Author: chong
 * @Data: 2021/7/19 11:26 下午
 */
public class MemoryMethod {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int num : prices){  // 求数组中最大值，确定一下缓存大小,因为数组列存的是stock，所以要直到prices中的最大值
            max = Math.max(max, num);
        }
        int[][] memory = new int[prices.length][max + 2];    // 两个可变参数，二维数组
        for (int i = 0; i < memory.length; i++){
            for (int j = 0; j < memory[0].length; j++){
                memory[i][j] = -2;         // 做初始化，设置memory初始值
            }
        }
        return process(prices, 0, -1, memory);
    }

    public int process(int[] prices, int index, int stock, int[][] memory){
        if (index >= prices.length){   // base case
            return 0;
        }

        // 这里有点不同，因为stock是可以等于-1的，范围其实是-1～max，但是如果直接把-1也作为memory的下标就会越界
        // 所以这里搞个变量tempInd，把-1转移到memory数组最后一位放置
        int tempInd = stock == -1 ? memory[0].length - 1 : stock;

        if (memory[index][tempInd] != -2){
            return memory[index][tempInd];
        }

        int p1 = 0;   // p1和p2分别表示选择买入（卖出）或者不买入（不卖出）的情况下获得的最大利润
        int p2 = 0;
        if (stock == -1){   // 表示此时手中没有股票，可以选择买入
            p1 = process(prices, index + 1, prices[index], memory);  // 选择买入，此时手上的股票stock为买入时价格
            p2 = process(prices, index + 1, -1, memory);     // 选择不买，此时stock=-1表示手上没有股票
        }else {  // stock != -1,表示此时手上有股票
            if (prices[index] > stock){   // 当前股票价格大于手上股票的价格才有必要考虑卖出
                // 选择卖出，由于冷冻期，所以要跳过下一天，index直接+2；另外要把差价统计进p1中
                p1 = process(prices, index + 2, -1, memory) + (prices[index] - stock);
            }
            p2 = process(prices, index + 1, stock, memory);   // 无论差价是否为负数，都可以选择不卖
        }

        memory[index][tempInd] = Math.max(p1, p2);
        return memory[index][tempInd];    // 返回两种情况的最大值
    }

    @Test
    public void test(){
        int[] prices = {1, 2, 3, 0, 2};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
