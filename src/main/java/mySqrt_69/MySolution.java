package mySqrt_69;

import org.junit.Test;
import sun.reflect.LangReflectAccess;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/12 9:10 下午
 */
public class MySolution {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x == 1){
            return 1;
        }

        int left = 0;
        int right = x - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (mid > x / mid){   // 改用除法防止乘法溢出
                right = mid - 1;
            }else if(mid * mid < x){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left * left > x ? left - 1 : left;
    }

    @Test
    public void test() {
        int res = mySqrt(21);
        System.out.println(res);
    }
}
