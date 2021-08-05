package trap_42;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 双指针解法：实际上就是对于dp备忘录再做一个优化，双指针边遍历边记录左右最大值，省去了多余的空间开销
 * @Author: chong
 * @Data: 2021/8/4 3:56 下午
 */
public class OfficialSolution_3 {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int res = 0;
        // 左右指针
        int left = 0;
        int right = height.length - 1;

        // 左右指针的左右区域当前的最大值
        int lMax = height[0];
        int rMax = height[height.length - 1];

        while (left <= right){   // 这个方法不是从左往右遍历，而是双指针收缩遍历整个数组
            lMax = Math.max(lMax, height[left]);   // 更新最大值
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax){  // 说明此时是左边最大值决定能盛多少水，而右边无论是有更小的还是更大的值都不会影响最终结果
                res += lMax - height[left];
                left++;
            }else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }
}
