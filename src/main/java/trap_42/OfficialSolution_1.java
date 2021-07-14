package trap_42;

import org.junit.Test;

/**
 * @Description:
 * 动态规划，在暴力法的基础上用两个dp数组保存左右最大值
 * 时间复杂度：O（N），空间复杂度：O（N）
 * @Author: chong
 * @Data: 2021/6/11 2:04 下午
 */
public class OfficialSolution_1 {
    public int trap(int[] height){
        int result = 0;
        int[] leftMaxDp = new int[height.length];
        int[] rightMaxDp = new int[height.length];
//        第一次循环找出每个位置的左侧最大值记录下来
        for (int i = 1; i < height.length; i++){
            leftMaxDp[i] = Math.max(height[i - 1], leftMaxDp[i - 1]);
        }
//        第二次同上
        for (int i = height.length - 2; i >= 0; i--){
            rightMaxDp[i] = Math.max(height[i + 1], rightMaxDp[i + 1]);
        }

        for (int i = 0; i < height.length; i++){
            int minValue = Math.min(leftMaxDp[i], rightMaxDp[i]);
            if (minValue > height[i])
                result += minValue - height[i];
        }
        return result;
    }

    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }
}
