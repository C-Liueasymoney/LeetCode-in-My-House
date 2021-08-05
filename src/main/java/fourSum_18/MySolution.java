package fourSum_18;

import org.junit.Test;

import javax.naming.spi.ResolveResult;
import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/31 4:06 下午
 */
public class MySolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++){
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++){  // 先固定两个位置，剩下两个用双指针优化
                // 遇到固定位置和上一次遍历相同的情况，就跳过，防止出现相同结果
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target){
                        left++;
                    }else if (sum > target){
                        right--;
                    }else {
                        List<Integer> temp = new ArrayList<>();
                        Collections.addAll(temp, nums[i], nums[j], nums[left], nums[right]);
                        res.add(temp);
                        // 保证left和right指针产生变化,继续下一轮查找
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        // 不满足上面的条件时，再改变指针
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }
}
