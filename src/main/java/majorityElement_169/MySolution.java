package majorityElement_169;

import org.junit.Test;

import java.awt.event.FocusEvent;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/15 11:07 下午
 */
public class MySolution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums){
            if (count == 0)
                candidate = num;
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 2, 3, 2, 2};
        int res = majorityElement(nums);
        System.out.println(res);
    }
}
