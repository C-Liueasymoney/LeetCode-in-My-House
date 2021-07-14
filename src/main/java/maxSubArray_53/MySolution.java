package maxSubArray_53;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/15 2:15 下午
 */
public class MySolution {
    public int maxSubArray(int[] nums){
        int result = nums[0];
        int dpMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > dpMax + nums[i])
                dpMax = nums[i];
            else
                dpMax += nums[i];
            result = Math.max(result, dpMax);
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {1, 2};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
