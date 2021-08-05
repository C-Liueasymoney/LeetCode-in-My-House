package subarraySum_560;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * 前缀和
 * @Author: chong
 * @Data: 2021/8/4 4:25 下午
 */
public class MySolution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;

        // 前缀和数组
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                if (preSum[j + 1] - preSum[i] == k)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1};
        int res = subarraySum(nums, 0);
        System.out.println(res);
    }
}
