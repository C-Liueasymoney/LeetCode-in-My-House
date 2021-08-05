package subarraySum_560;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 哈希表优化前缀和
 * @Author: chong
 * @Data: 2021/8/4 4:50 下午
 */
public class MySolution2 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;
        // key代表前缀和是多少，value代表此前缀和出现了几次
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // 先记录下第一位

        // 前缀和数组
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(preSum[i + 1] - k)){
                res += map.get(preSum[i + 1] - k);    // 把map中存放的出现次数都加上
            }
            map.put(preSum[i + 1], map.getOrDefault(preSum[i + 1], 0) + 1);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1};
        int res = subarraySum(nums, 2);
        System.out.println(res);
    }
}
