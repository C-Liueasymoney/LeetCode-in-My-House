package twoSum_167;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/27 6:37 下午
 */
public class MySolution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] < target){
                left++;
            }else if (numbers[left] + numbers[right] > target){
                right--;
            }else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

}
