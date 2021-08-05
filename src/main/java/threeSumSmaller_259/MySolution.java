package threeSumSmaller_259;

import org.omg.CORBA.RepositoryIdHelper;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/31 4:46 下午
 */
public class MySolution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target){
                    right--;
                }else {
                    // 遇到比target小的，那么右指针直到移动到左指针的位置的范围都是小于target的
                    res += right - left;
                    // 记录这个范围后，把左指针右移
                    left++;
                }
            }
        }
        return res;
    }
}
