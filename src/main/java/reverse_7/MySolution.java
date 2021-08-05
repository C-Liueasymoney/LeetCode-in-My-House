package reverse_7;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/3 4:44 下午
 */
public class MySolution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int temp = x % 10;

            if ((res == 214748364 && temp > 7) || res > 214748364)
                return 0;

            if ((res == -214748364 && temp < -8) || res < -214748364)
                return 0;

            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        int res = reverse(123);
        System.out.println(res);
    }
}
