package singleNumber_136;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/7 5:08 下午
 */
public class MySolution {
    public int singleNumber(int[] nums){
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}
