package canJump_55;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/15 6:56 下午
 */
public class MySolution {
    public boolean canJump(int[] nums){
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > len)
                return false;
            len = Math.max(len, i + nums[i]);
            if (len >= nums.length - 1)
                return true;
        }
        return true;
    }

    @Test
    public void test(){
        int[] nums = {2, 0, 0};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
