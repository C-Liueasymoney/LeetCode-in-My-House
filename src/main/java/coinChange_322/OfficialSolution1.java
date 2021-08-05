package coinChange_322;

import org.junit.Test;

/**
 * @Description:
 * 记忆化搜索
 * @Author: chong
 * @Data: 2021/7/19 2:56 下午
 */
public class OfficialSolution1 {
    public int coinChange(int[] coins, int amount) {
        // 创建一个dp数组，来保存下递归过程中已经得到的结果，由于amount传入process中是rest是可变参数，所以用它来作为数组长度
        int[] dp = new int[amount + 1];
        return process(coins, amount, dp);
    }

    /**
     *
     * @param coins 硬币数组， 固定参数
     * @param rest 当前拿到一些硬币后，还需要凑的数目， 可变参数
     * @return 返回拿了最少数目的硬币数
     */
    public int process(int[] coins, int rest, int[] dp){
        if (rest < 0){   // 表示上一步拿了硬币之后rest<0,那这一步无论如何凑不了rest了，返回-1
            return -1;
        }
        if (rest == 0){  // 表示上一步拿完硬币之后总和正好等于amount，使得rest=0，这一步不需要再拿硬币，返回0
            return 0;
        }

        // 这里不满足上面两个情况的话，先检查dp数组有没有已经算好了的值
        if (dp[rest] != 0){   // 这里注意，我们的dp数组中不会存0值，因为如果当前不需要再拿硬币，那直接返回0，不用记录，但是-1是要记录的
            return dp[rest];
        }

        // rest>0
        int min = Integer.MAX_VALUE;    // 表示此轮拿每一个coins中硬币所得到的最小硬币数
        for (int i = 0; i < coins.length; i++){
            int temp = process(coins, rest - coins[i], dp);  // 把rest减去拿的硬不数值传给下一轮递归，得到的是最小硬币数
            if (temp >=0 && temp < min){   // temp不等于-1（先不让返回的-1干扰结果），而且temp比min小，就可以更新最小硬币数
                min = temp;
            }
        }

        if (min == Integer.MAX_VALUE){    // 说明min没被更新，那么传上来的都是-1，表示此时不管拿哪个硬币都不能凑到amount，这一步也返回-1
            dp[rest] = -1;    // dp数组缓存-1，下次遇到rest时，就可以直接返回-1
            return dp[rest];
        }
        dp[rest] = min + 1;
        return dp[rest];    // 最后要+1，因为在这一轮又拿了一个硬币要计算在内
    }

    @Test
    public void test(){
        int[] nums = {2, 1, 4, 5};
        int res = coinChange(nums, 23);
        System.out.println(res);
    }
}
