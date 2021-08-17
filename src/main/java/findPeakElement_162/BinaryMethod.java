package findPeakElement_162;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import org.junit.Test;

/**
 * @Description:
 * 二分查找
 * 注意两边的端点，在nums[-1]和nums[n]都被视为负无穷，所以如果nums[1] < nums[0]或者nums[n - 2] < nums[n -1]的话
 * 这两个端点也算峰值
 * 并且相邻元素不会相等
 * @Author: chong
 * @Data: 2021/8/14 6:21 下午
 */
public class BinaryMethod {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            // 表示此时中点处于一个上升的坡中，峰值在右
            if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] nums = {1,2};
        int res = findPeakElement(nums);
        System.out.println(res);
    }
}
