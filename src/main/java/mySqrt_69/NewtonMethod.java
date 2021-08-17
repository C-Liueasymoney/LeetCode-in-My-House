package mySqrt_69;

import org.junit.Test;

/**
 * @Description:
 * 牛顿迭代法
 * @Author: chong
 * @Data: 2021/8/13 5:05 下午
 */
public class NewtonMethod {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }

        double C = x;
        double x0 = x;
        while (true){
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7)
                break;
            x0 = xi;
        }
        return (int) x0;
    }

    @Test
    public void test() {
        int res = mySqrt(21);
        System.out.println(res);
    }
}
