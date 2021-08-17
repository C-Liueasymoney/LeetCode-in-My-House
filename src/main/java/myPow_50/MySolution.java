package myPow_50;

import org.junit.Test;

/**
 * @Description:
 * 暴力解法超时
 * @Author: chong
 * @Data: 2021/8/13 5:59 下午
 */
public class MySolution {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        if (n == 0){
            return 1;
        }

        int pow = Math.abs(n);
        double dep = x;

        for (int i = 0; i < pow - 1; i++){
            x *= dep;
        }

        return n < 0 ? 1 / x : x;
    }

    @Test
    public void test() {
        double res = myPow(2.0, -2);
        System.out.println(res);
    }
}
