package climbStairs_70;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/19 8:34 上午
 */
public class MySolution {
    public int climbStairs(int n){
        int pre = 1;
        int last = 2;
        if (n == 1)
            return pre;
        if (n == 2)
            return last;
        for (int i = 2; i < n; i++){
            int temp = pre + last;
            pre = last;
            last = temp;
        }
        return last;
    }

    @Test
    public void test(){
        int res = climbStairs(5);
        System.out.println(res);
    }
}
