package mySqrt_69;

import org.junit.Test;

/**
 * @Description:
 * 带有精度的实现
 * 注意right=mid和left=mid
 * @Author: chong
 * @Data: 2021/8/13 5:43 下午
 */
public class MySolution2 {
    public double mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x == 1){
            return 1;
        }

        double left = 0;
        double right = x - 1;
        while (left < right){
            double mid = left + ((right - left) / 2);
            if (mid > x / mid){   // 改用除法防止乘法溢出
                right = mid;
            }else if(mid * mid < x){
                left = mid;
            }else{
                return mid;
            }
            if (Math.abs((double) x - mid * mid) < 1e-5){
                return mid;
            }
        }
        return left * left > x ? left - 1 : left;
    }

    @Test
    public void test() {
        double res = mySqrt(8);
        System.out.println(res);
    }
}
