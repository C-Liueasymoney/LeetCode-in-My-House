package coinChange_322;

import org.junit.Test;

import java.awt.image.RescaleOp;

/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/7/19 3:43 下午
 */
public class OfficialSolution2 {
    public int coinChange(int[] coins, int amount) {
        // 1、由于在暴力递归方法中，递归函数只有一个可变参数，dp数组只用创建一个一维数组
        int[] dp = new int[amount + 1];  // 其中元素下标用rest表示，代表还剩多少钱要拿

        // 2、终止位置很明显在rest=11处，也就是剩11块钱要拿（假设此时amount=11）

        // 3、base case rest<0不用看了，rest==0处设置为0
        dp[0] = 0;

        // 4、接下来看普遍位置如何依赖，在暴力递归方法中，是要求出rest确定下遍历一遍coins数组得到的最小值
        // 因此也就是min(dp[rest - coins[i]))，其中可能会越界，越界情况直接设置为-1

        // 5、定义遍历dp的顺序，明显每一格子要依赖前面的格子，所以遍历顺序从左到右

        // 6、最后copy暴力递归方法，改成动态规划
        for (int rest = 1; rest <= amount; rest++){
            int min = Integer.MAX_VALUE;    // 表示此轮拿每一个coins中硬币所得到的最小硬币数

            for (int i = 0; i < coins.length; i++){
                int temp = -1;   // 初始先设置temp等于-1
                if (rest - coins[i] >= 0){   // 如果rest - coins[i]不会越界，再更新dp到temp中
                    temp = dp[rest - coins[i]];
                }
                // 这里之前如果越界了temp就是-1，不进入下面判断，如果temp大于min，也没必要进入判断。
                if (temp >=0 && temp < min){   // temp不等于-1（先不让返回的-1干扰结果），而且temp比min小，就可以更新最小硬币数
                    min = temp;
                }
            }
            // 最后一轮coins遍历完成，看看min有没有进行更新，没有就给对应dp中赋值-1，否则赋值min得到的当前rest最小值加1（别往了+1！！）
            dp[rest] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }

        return dp[amount];   // 最后返回终止位置
    }

    @Test
    public void test(){
        int[] nums = {2};
        int res = coinChange(nums, 3);
        System.out.println(res);
    }
}
