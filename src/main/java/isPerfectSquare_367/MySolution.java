package isPerfectSquare_367;

import org.junit.Test;

import java.util.MissingFormatArgumentException;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/14 4:14 下午
 */
public class MySolution {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        if (num == 2){
            return false;
        }
        int left = 0;
        int right = num - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (mid > num / mid){
                right = mid - 1;
            }else if (mid <= num / mid){
                left = mid + 1;
            }
        }
        return left * left == num || (left - 1) * (left - 1) == num;
    }

    @Test
    public void test() {
        boolean res = isPerfectSquare(4);
        System.out.println(res);
    }
}
