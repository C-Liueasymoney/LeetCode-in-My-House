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
        // leftRes、rightRes保存最后的结果，即左右边界
        int leftRes = -1;
        int rightRes = -1;
        int left = 0;
        int right = nums.length - 1;
        // 第一次遍历，寻找左边界
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            // 唯一要注意的地方就是，当mid和target相等时，并不返回，而是继续缩小范围，把right指针左移
            // 由于mid肯定是落在数组中间偏左，并且循环终止条件是left<=right，那么最后一步肯定是left和right都落在target的最左元素上
            // 所以最后退出循环后left位置就是左边界
            else
                right = mid - 1;
        }
        // 这个判断是要防止数组中没有target元素
        if (left < nums.length && target == nums[left])
            leftRes = left;

        left = 0;
        right = nums.length - 1;
        // 开始搜索右边界，过程同上
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
