package twoSum_1;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/4 9:39 上午
 */
public class MySolution {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
//            如果map中有过与当前nums[i]相加等于target的就返回
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            // 要放在后面，防止map中已有相同的key
            map.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
}
