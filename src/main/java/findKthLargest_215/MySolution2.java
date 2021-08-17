package findKthLargest_215;

import org.junit.Test;

/**
 * @Description:
 * 利用快排的分区思想，做到不用对整个数组完全排序，并且无需递归调用产生额外栈空间
 * @Author: chong
 * @Data: 2021/8/6 3:50 下午
 */
public class MySolution2 {

    public int findKthLargest(int[] nums, int k){
        int left = 0;
        int right = nums.length - 1;

        // 这里得出k应该在排好序的数组下标
        int kIndex = nums.length - k;

        while (left <= right){
            int index = partition(nums, left, right);
            if (index == kIndex) {  // 说明此时分区中点已经落在kIndex上，右边正好有k-1个比其大的数字,默认相同的元素也算，所以没问题
                return nums[index];
            }else if (index < kIndex){   // 说明分区点右边大数比k-1多，继续在右分区找
                left = index + 1;
            }else {
                right = index - 1;    // 去左分区找
            }
        }
        return nums[left];
    }

    public int partition(int[] nums, int left, int right){

        // 这里就是正常的快排分区，返回分区点
        swap(nums, left, left + ((int) (Math.random() * (right - left + 1))));
        int pivot = nums[left];

        int low = left;
        int high = right;

        while (low < high){
            while (low < high) {
                if (nums[high] >= pivot){
                    high--;
                }else {
                    nums[low] = nums[high];
                    break;
                }
            }

            while (low < high){
                if (nums[low] <= pivot){
                    low++;
                }else {
                    nums[high] = nums[low];
                    break;
                }
            }
        }

//        for (int high = left + 1; high <= right; high++){
//            if (nums[high] < pivot){
//                low++;
//                swap(nums, low, high);
//            }
//        }
//        swap(nums, left, low);
        nums[low] = pivot;
        return low;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    @Test
    public void test(){
        int[] nums = {3,3,2,1,5,6,6,4};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }
}
