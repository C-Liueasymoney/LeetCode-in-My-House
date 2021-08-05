package triangleNumber_611;

import java.util.Arrays;

/**
 * @Description:
 * 三角形成立的条件就是两边之和大于第三边，那我们就排序数组，然后固定一个数字遍历，另外两个数字采用双指针指向
 * @Author: chong
 * @Data: 2021/7/31 5:06 下午
 */
public class MySolution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int res = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--){  // 这道题需要反向遍历
            int left = 0;
            int right = i - 1;
            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum <= nums[i]){
                    left++;
                }else {
                    res += right - left;
                    right--;
                }
            }
        }

        return res;
    }
}
