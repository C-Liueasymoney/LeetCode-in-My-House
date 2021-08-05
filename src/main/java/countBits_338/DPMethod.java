package countBits_338;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 动态规划版本
 * @Author: chong
 * @Data: 2021/7/21 6:35 下午
 */
public class DPMethod {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];   // 一个可变参数，长度对应0～n个值
        // 终止状态就是求出的整个dp表
        // 根据base，0位置等于0
        // 依照递归关系，得出依赖关系是偶数依赖其除以2的结果，奇数依赖其值减1，所以从左到右遍历
        for (int num = 1; num < dp.length; num++){
            if (num % 2 == 0){
                dp[num] = dp[num / 2];
            }else {
                dp[num] = dp[num - 1] + 1;
            }
        }
        return dp;
    }

    @Test
    public void test(){
        int[] res = countBits(15);
        System.out.println(Arrays.toString(res));
    }
}
