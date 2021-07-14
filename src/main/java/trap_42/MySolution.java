package trap_42;

import org.junit.Test;

import java.time.zone.ZoneOffsetTransitionRule;

/**
 * @Description:
 * 暴力求解，时间复杂度O（N^2）
 * @Author: chong
 * @Data: 2021/6/11 8:56 上午
 */
public class MySolution {
    public int trap(int[] height){
        int result = 0;
        for (int i = 0; i < height.length; i++){
            int leftMax = 0;
            int rightMax = 0;
            for (int k = i; k >= 0; k--){
                leftMax = Math.max(height[k], leftMax);
            }
            for (int k = i; k < height.length; k++){
                rightMax = Math.max(height[k], rightMax);
            }
            if (leftMax > height[i] && rightMax > height[i]) {
                    result += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] height = {4,2,0,3,2,5};
        int res = trap(height);
        System.out.println(res);
    }
}
