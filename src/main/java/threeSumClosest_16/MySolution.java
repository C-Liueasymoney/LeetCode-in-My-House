package threeSumClosest_16;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/31 3:30 下午
 */
public class MySolution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int abs = Integer.MAX_VALUE;  // 初始绝对值

        // 需要对数组中每个数遍历，确保双指针能组合出所有方法
        for (int i = 0; i < nums.length - 2; i++) {
            // 设置左右指针
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {   // 当左右指针之间不具有3个元素时终止循环
                int temp = nums[i] + nums[left] + nums[right];
                if (temp < target) {
                    left++;
                } else if (temp > target) {
                    right--;
                } else {
                    return temp;
                }
                if (Math.abs(temp - target) < abs) {
                    abs = Math.abs(temp - target);
                    res = temp;
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {0, 2, 1, -3};
        int res = threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
