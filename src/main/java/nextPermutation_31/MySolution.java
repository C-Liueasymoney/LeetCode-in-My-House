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
        // 从后向前寻找第一个相对升序的元素对，找到直接break
        // 比如：123465，找到第一个就是smallerIndex = 3 edgeIndex = 4
        // 那如果是654321，没有升序元素对，最后smallerIndex = 0, edgeIndex = 1，最后一步翻转的时候就得到123456
        // 之所以要这么找，基于一个原则：我想找到一个相对小一点的数字，拿这个数字和后面的数字交换，可以让整个数字变大
        // 但这个数字不能太靠前，会导致数字变得太大
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                smallerIndex = i;
                edgeIndex = i + 1;
                break;
            }
        }
//        找较大值
        // 接着从后向前到edgeIndex为止(因为edgeIndex是smallerIndex后面第一个大于它的数字)寻找第一个大于smallerIndex的数字
        // 比如：123465,smallerIndex = 3 edgeIndex = 4，那么找到的higherIndex就是5
        // 比如：654321，smallerIndex = 0, edgeIndex = 1，找到的higherIndex就是1
        // 之所以要这么找，基于一个原则就是：我要拿这个数字和前面的数字交换，那这个数字一定要大于前面的数字，并且要第一个大，否则
        // 就不能满足下一个最大的含义了
        for (int i = nums.length - 1; i >= edgeIndex; i--){
            if (nums[i] > nums[smallerIndex]){
                higherIndex = i;
                break;
            }
        }
//        交换较小和较大值
        // 比如：123465,smallerIndex = 3 edgeIndex = 4，higherIndex=5，交换结果就是:123564
        swap(nums, smallerIndex, higherIndex);
//        反转边缘之后的子数组
        // 最后翻转得到：123546，要保证交换后edgeIndex后面元素是升序的
        // 之所以保证后面升序，是因为前一位smallIndex已经变大了，那么后面的位就要从最小的情况开始排列
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
