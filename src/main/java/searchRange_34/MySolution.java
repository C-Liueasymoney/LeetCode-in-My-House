package searchRange_34;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/10 9:15 上午
 */
public class MySolution {
    public int[] searchRange(int[] nums, int target){
        if (nums.length == 0)
            return new int[]{-1, -1};
        int leftRes = -1;
        int rightRes = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                right = mid - 1;
        }
        if (left < nums.length && target == nums[left])
            leftRes = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (right >= 0 && target == nums[right])
            rightRes = right;

        return new int[]{leftRes, rightRes};
    }

    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
