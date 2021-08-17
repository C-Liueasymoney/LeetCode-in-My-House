package removeDuplicates_26;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/11 4:14 下午
 */
public class MySolution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int slow = 1;
        int fast = 1;

        while (fast != nums.length){
            if (nums[fast] == nums[fast - 1]){
                fast++;
            }else {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
