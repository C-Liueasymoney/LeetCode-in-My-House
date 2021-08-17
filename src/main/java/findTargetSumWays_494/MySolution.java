package findTargetSumWays_494;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/11 8:28 下午
 */
public class MySolution {
    public int findTargetSumWays(int[] nums, int target) {
        return process(nums, target, 0);
    }

    public int process(int[] nums, int target, int index){
        if (index == nums.length && target == 0){
            return 1;
        }

        if (index == nums.length){
            return 0;
        }

        return process(nums, target + nums[index], index + 1) +
                process(nums, target - nums[index], index + 1);
    }

    @Test
    public void test() {
        int[] nums = {1,1,1,1,1};
        int res = findTargetSumWays(nums, 3);
        System.out.println(res);
    }
}
