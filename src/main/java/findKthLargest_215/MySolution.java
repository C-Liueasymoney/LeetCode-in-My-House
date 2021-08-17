package findKthLargest_215;

import org.junit.Test;

/**
 * @Description:
 * 利用快速排序思想找到数组中第k大元素
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
        // 到此为止以上的方法和快排相同
        // 这里看此时数组中分割点右侧的元素数量是否等于k，如果等于的话说明分割点右边有k个比其大的，那么在这个小数组中第k大的就是nums[low]
        if (right - low + 1 == k)
            return nums[low];
        // 如果右边比nums[low]大的元素小于k，那要继续去这个小数组的左侧去找，并且k要减去右侧已经比较大的元素数量
        else if (right - low + 1 < k)
            return partition(nums, k - (right - low + 1), left, parIndex - 1);
        else
            // 否则去右手边去找
            return partition(nums, k, parIndex + 1, right);
    }

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int res = findKthLargest(nums, 3);
        System.out.println(res);
    }
}
