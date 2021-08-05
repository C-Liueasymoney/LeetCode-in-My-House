package lengthOfLIS_300;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/7/19 6:03 下午
 */
public class MySolution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res = Math.max(process(nums, i), res);
        }
        return res;
    }

    public int process(int[] nums, int index){
        if (index == nums.length){
            return 0;
        }

        int max = 0;
        for (int i = index + 1; i < nums.length; i++){
            int temp = 0;
            if (nums[i] > nums[index]){
                temp = process(nums, i);
                max = Math.max(temp, max);
            }
        }

        return max + 1;
    }

    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
