package coinChange_322;

import org.junit.Test;
import sun.jvm.hotspot.debugger.Page;

/**
 * @Description:  这道题展示如何从暴力递归一步一步优化为动态规划
 * 暴力递归的方式,此方式复杂度为O(amount^coins.length)，时间复杂度太高，接下来需要使用记忆化搜索改进
 * @Author: chong
 * @Data: 2021/7/18 6:53 下午
 */
public class MySolution {
    public int coinChange(int[] coins, int amount) {
        return process(coins, amount);
    }

    /**
     *
     * @param coins 硬币数组
     * @param rest 当前拿到一些硬币后，还需要凑的数目
     * @return 返回拿了最少数目的硬币数
     */
    public int process(int[] coins, int rest){
        if (rest < 0){   // 表示上一步拿了硬币之后rest<0,那这一步无论如何凑不了rest了，返回-1
            return -1;
        }
        if (rest == 0){  // 表示上一步拿完硬币之后总和正好等于amount，使得rest=0，这一步不需要再拿硬币，返回0
            return 0;
        }

        // rest>0
        int min = Integer.MAX_VALUE;    // 表示此轮拿每一个coins中硬币所得到的最小硬币数
        for (int i = 0; i < coins.length; i++){
            int temp = process(coins, rest - coins[i]);  // 把rest减去拿的硬不数值传给下一轮递归，得到的是最小硬币数
            if (temp >=0 && temp < min){   // temp不等于-1（先不让返回的-1干扰结果），而且temp比min小，就可以更新最小硬币数
                min = temp;
            }
        }

        if (min == Integer.MAX_VALUE){    // 说明min没被更新，那么传上来的都是-1，表示此时不管拿哪个硬币都不能凑到amount，这一步也返回-1
            return -1;
        }
        return min + 1;    // 最后要+1，因为在这一轮又拿了一个硬币要计算在内
    }

    @Test
    public void test(){
        int[] nums = {2, 1, 4, 5};
        int res = coinChange(nums, 23);
        System.out.println(res);
    }
}
