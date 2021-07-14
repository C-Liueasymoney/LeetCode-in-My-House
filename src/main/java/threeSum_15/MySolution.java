package threeSum_15;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/7 10:08 上午
 */
public class MySolution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
//        数组排序
        Arrays.sort(nums);
//        最多只循环到length-2位，因为后面要留出两位
        for (int i = 0; i < nums.length - 2; i++){
//            去重，如果i的前一位和i相等，就不应该再循环它，防止重复结果
            if (i == 0 || nums[i] != nums[i - 1]){
//                内层循环定义双指针
                int left = i + 1;
                int right = nums.length - 1;
//                双指针相遇即停止
                while (left < right){
//                    三数相加<0说明左指针太小，left++
                    if (nums[i] + nums[left] + nums[right] < 0)
                        left++;
//                    >0说明右指针太大，right--
                    else if (nums[i] + nums[left] + nums[right] > 0)
                        right--;
//                    相加=0下还要进行判断，左指针是否与上一位相等，再次去重
                    else {
                        if (left == i + 1 || nums[left] != nums[left - 1]){
                            List<Integer> tempList = new ArrayList<>();
                            Collections.addAll(tempList, nums[i], nums[left], nums[right]);
                            result.add(tempList);
                        }
                        left++;
                    }
                }
            }
//            当i>0时由于数组已经排序那么后面的数组相加都不会再等于0了，可以直接跳出
            if (nums[i] > 0)
                break;
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
