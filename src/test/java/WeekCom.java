import org.junit.Test;
import sun.jvm.hotspot.runtime.ConcurrentLocksPrinter;

import java.awt.font.NumericShaper;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Description:
 * 周赛专用
 * @Author: chong
 * @Data: 2021/8/8 10:17 上午
 */
public class WeekCom {
    public int minNonZeroProduct(int p) {
        if (p == 1)
            return 1;

        int a = (int) Math.pow(2, p) - 1;
        int res = 1;
        int temp = 1;
        for (int i = 0; i < (a - 1) / 2; i++){
            if (temp >= 1000000007){

            }
            temp = temp * (a - 1);
        }
        res *= a % 1000000007;
//        int res = (int) Math.pow(a - 1, (a - 1) / 2) % 1000000007;
//        res *= a;
        return (int) res;
    }



    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



    @Test
    public void test(){
        int res = minNonZeroProduct(5);
        System.out.println(res);
//        202795991
        System.out.println(Math.pow(30, 15) % 1000000007 * 31);
    }
}
