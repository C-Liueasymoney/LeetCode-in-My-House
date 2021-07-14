package search_33;

import org.junit.Test;


/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 10:06 下午
 */
public class MySolution {
    public int search(int[] nums, int target){
        int hugeNumInd = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] >= nums[0])
                left = middle + 1;
            else
                right = middle - 1;
        }
        hugeNumInd = right;

        if (target >= nums[0]){
            left = 0;
            right = hugeNumInd;
        }else {
            left = hugeNumInd + 1;
            right = nums.length - 1;
        }
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] > target)
                right = middle - 1;
            else if (nums[middle] < target)
                left = middle + 1;
            else
                return middle;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {4,5,6,7,0,1,2};
        int res = search(nums, 0);
        System.out.println(res);
    }
}
