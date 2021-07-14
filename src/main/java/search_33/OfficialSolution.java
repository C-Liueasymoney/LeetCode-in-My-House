package search_33;


/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 11:00 下午
 */
public class OfficialSolution {
    public int search(int[] nums, int target){
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[0]){
                if (target >= nums[0] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }else {
                if (target <= nums[nums.length - 1] && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return  -1;
    }
}
