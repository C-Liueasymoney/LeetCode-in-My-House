package findPeakElement_162;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/14 6:09 下午
 */
public class MySolution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                return i - 1;
            }
        }
        return nums.length - 1;
    }

    @Test
    public void test() {
        int[] nums = {1,2,1,3,5,6,4};
        int res = findPeakElement(nums);
        System.out.println(res);
    }
}
