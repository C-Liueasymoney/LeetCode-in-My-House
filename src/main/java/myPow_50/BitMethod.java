package myPow_50;

import org.junit.Test;

/**
 * @Description:
 * 暴力方法超时，那么我们就来试试聪明的位运算方法
 * 幂是n，可以把它转化为二进制表示，比如n=5 则二进制为0101
 * 我们可以设t=x，也就是t是基底，比如t=x=2，也就是现在要求2的五次方2^5
 * 然后把n右移，最低位是1，于是此时t = t * 1，res = t = 2
 * 然后第二位是0，此时t = t * t = 4，res不累乘
 * 第三位是1，此时t = t * t = 16，此时res累乘t res = 2 * t = 32
 * 得出结果
 *
 * @Author: chong
 * @Data: 2021/8/13 6:06 下午
 */
public class BitMethod {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        if (n == 0){
            return 1;
        }

        double t = x;
        int pow = Math.abs(n);
        double res = 1.0;

        for (int i = 0; i < 32; i++){
            if ((pow & 1) != 0){ // 每次遇到最低位为1就在结果上乘对应的t
                res *= t;
            }
            // 幂次每次右移一位
            pow = pow >> 1;
            // 基底每次阶乘，也就是x!
            t *= t;
        }

        return n < 0 ? 1 / res : res;
    }


    @Test
    public void test() {
        double res = myPow(1.00000, 2147483647);
        System.out.println(res);
    }
}
