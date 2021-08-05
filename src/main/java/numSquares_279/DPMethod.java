package numSquares_279;

import org.junit.Test;

/**
 * @Description:
 * 最后根据暴力递归，写出动态规划方法
 * @Author: chong
 * @Data: 2021/7/19 4:28 下午
 */
public class DPMethod {
    public int numSquares(int n) {
        // 1、确定几维，可变参数就一个=》1维
        int[] dp = new int[n + 1];
        // 2、确定终止位置。在rest=n处
        // 3、确定base case得到的初始条件
        dp[0] = 0;     // rest=0 返回0
        // 4、确定普遍位置如何依赖，看暴力递归方法中递归函数是怎么调的
        // 得到递推公式：dp[rest] = dp[rest - i * i]  // 其中i*i表示完全平方数

        // 5、确定遍历顺序：明显依赖前面的，从左向右遍历
        for (int rest = 1; rest <= n; rest++){
            int min = Integer.MAX_VALUE;

            // 这一段几乎和暴力递归的部分一样
            for (int i = 1; i * i <= rest; i++){    // 遍历1到rest范围内所有完全平方数
                // 注意这里不用考虑越界，因为遍历条件已经规定了，i*i<=rest
                int temp = dp[rest - i * i];
                min = Math.min(min, temp);    // 更新min的最小值
            }

            dp[rest] = min + 1; // 别忘了+1
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numSquares(13));
    }
}
