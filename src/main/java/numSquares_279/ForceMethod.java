package numSquares_279;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归,本方法依旧超时，继续加入记忆化搜索优化时间复杂度
 * @Author: chong
 * @Data: 2021/7/19 4:12 下午
 */
public class ForceMethod {
    public int numSquares(int n) {
        return process(n);
    }

    /**
     *
     * @param rest 当前步骤目标n还剩下多少，可变参数（比如n=12，减去一个完全平方数4，传入rest就是8）
     * @return 当前rest下还需要最少几个完全平方数才能使rest=0
     */
    public int process(int rest){
        if (rest == 0){   // base case 如果rest已经等于0了，不再需要任何数字使其成为0，直接返回0
            return 0;
        }
        // 另外注意rest不会小于0，因为有完全平方数1的存在

        // rest>0
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= rest; i++){    // 遍历1到rest范围内所有完全平方数
            int temp = process(rest - i * i);    // 传入rest减去一个完全平方数到递归调用中，temp是每个调用返回的最小数目
            min = Math.min(min, temp);    // 更新min的最小值
        }

        return min + 1;   // 要加一表示在此轮已经用了一个完全平方数，返回
    }


    @Test
    public void test(){
        System.out.println(numSquares(13));
    }
}
