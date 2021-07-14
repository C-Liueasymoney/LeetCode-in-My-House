package sortColors_75;

import org.junit.Test;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/19 9:45 上午
 */
public class MySolution {
    public void sortColors(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++){
//            这里不用考虑指针回退，因为left指针在左边，已经进行过调整不会出现交换过来一个2的情况
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }

            if (nums[i] == 2){
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
//                指针i回退！！因为调换过来如果不是1而是0或者2还需要对第i位进行调整
                if (nums[i] != 1)
                    --i;
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {2, 1, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
