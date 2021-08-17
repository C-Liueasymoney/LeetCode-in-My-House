package rotate_189;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 翻转数组：先把不需要旋转部分和旋转部分做一个翻转
 * 然后整体做一个翻转，就能得到旋转后的数组
 * @Author: chong
 * @Data: 2021/8/5 4:45 下午
 */
public class MySolution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1 || len == k)
            return;
        // k要对len求余，因为可能会向右移动超过len次
        k %= len;

        // 不需要旋转的部分翻转
        reverse(nums, 0, len - k - 1);
        // 需要旋转的部分翻转
        reverse(nums, len - k, len - 1);
        // 整体翻转
        reverse(nums, 0, len -1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    @Test
    public void test(){
        int[] nums = {1, 2};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
