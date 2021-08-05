package countBits_338;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/7/20 4:47 下午
 */
public class MySolution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++){
            res[i] = process(i);
        }
        return res;
    }

    public int process(int num){
        if (num == 0) {  // base case
            return 0;
        }

        if (num % 2 == 0){
            return process(num / 2);     // 如果是偶数，就等于其除2结果中的1数目，因为偶数最低位是0，除2就向右移一位，不影响1的数目
        }else {
            return process(num - 1) + 1; // 如果是奇数，等于其减1结果的1数目再加1，偶数最低位是1，减1把最低位的1去掉了，再加上一个
        }
    }

    @Test
    public void test(){
        int[] res = countBits(15);
        System.out.println(Arrays.toString(res));
    }
}
