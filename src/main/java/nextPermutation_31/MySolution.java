package nextPermutation_31;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 2:40 下午
 */
public class MySolution {
    public void nextPermutation(int[] nums){
//        要交换的较小和较大值的数组下标
        int smallerIndex = 0;
        int higherIndex = 0;
//        较小值后面的边缘数组下标
        int edgeIndex = 0;
//        找较小值
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                smallerIndex = i;
                edgeIndex = i + 1;
                break;
            }
        }
//        找较大值
        for (int i = nums.length - 1; i >= edgeIndex; i--){
            if (nums[i] > nums[smallerIndex]){
                higherIndex = i;
                break;
            }
        }
//        交换较小和较大值
        swap(nums, smallerIndex, higherIndex);
//        反转边缘之后的子数组
        reverse(nums, edgeIndex, nums.length - 1);
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test(){
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
