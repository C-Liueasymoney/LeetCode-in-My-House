package findKthLargest_215;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/20 9:46 上午
 */
public class MySolution {
    public int findKthLargest(int[] nums, int k){
        return partition(nums, k, 0, nums.length - 1);
    }

    private int partition(int[] nums, int k, int left, int right){
        int low = left;
        int high = right;
        int pivot = nums[low];

        while (low < high){
            while (low < high){
                if (pivot <= nums[high])
                    high--;
                else {
                    nums[low] = nums[high];
                    break;
                }
            }
            while (low < high){
                if (pivot >= nums[low])
                    low++;
                else {
                    nums[high] = nums[low];
                    break;
                }
            }
        }
        int parIndex = low;
        nums[low] = pivot;
        if (right - low + 1 == k)
            return nums[low];
        else if (right - low + 1 < k)
            return partition(nums, k - (right - low + 1), left, parIndex - 1);
        else
            return partition(nums, k, parIndex + 1, right);
    }

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int res = findKthLargest(nums, 3);
        System.out.println(res);
    }
}
