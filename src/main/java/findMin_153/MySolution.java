package findMin_153;

import java.util.ListResourceBundle;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/18 11:23 下午
 */
public class MySolution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int res = nums[left];

        if (nums[left] < nums[right]){
            return res;
        }

        while (left < right){
            if (right - left == 1){
                res = nums[right];
                break;
            }

            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= nums[left]){
                left = mid;
            } else if (nums[mid] <= nums[right]){
                right = mid;
            }
        }
        return res;
    }
}
