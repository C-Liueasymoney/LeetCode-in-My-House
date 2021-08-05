package productExceptSelf_238;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 空间优化版本
 * @Author: chong
 * @Data: 2021/7/16 11:18 下午
 */
public class OfficialSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // 设置两个变量，存放的是从左往右和从有右往左遍历产生的前缀乘积
        int left = 1;
        int right = 1;

        for (int i = 0; i < nums.length; i++){ // 把res数组初始化为全1
            res[i] = 1;
        }

        for (int i = 0; i < nums.length; i++){
            res[i] *= left;     // res每一轮都乘left积累的前缀乘积
            left *= nums[i];    // 这里由于不包括i位置，所以left在上一步为i位置赋值之后，再更新下一轮的乘积

            res[nums.length - i - 1] *= right;     // right是后缀乘积
            right *= nums[nums.length - i - 1];
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
