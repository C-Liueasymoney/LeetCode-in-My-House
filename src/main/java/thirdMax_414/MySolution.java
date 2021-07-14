package thirdMax_414;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 12:55 下午
 */
public class MySolution {
    public int thirdMax(int[] nums){
        if (nums.length < 2)
            return nums[0];
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums){
            set.add(num);
            if (set.size() > 3){
                set.pollFirst();
            }
        }
        if (set.size() < 3)
            return set.pollLast();
        else
            return set.pollFirst();
    }

    @Test
    public void test(){
        int[] nums = {1,2,2};
        int res = thirdMax(nums);
        System.out.println(res);
    }
}
