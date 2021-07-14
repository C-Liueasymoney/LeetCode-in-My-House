package maxArea_11;

import org.junit.Test;



/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/5 4:50 下午
 */
public class MySolution {
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(area, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }


    @Test
    public void test(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
}
