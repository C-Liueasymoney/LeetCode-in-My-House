package firstMissingPositive_41;

import org.junit.Test;

/**
 * @Description:
 * 原地哈希，先把原数组中的元素按照元素等于i，则放入下标值为i - 1的位置的规则哈希
 * 如果i - 1 小于0，或者大于数组长度或者元素已经处于此位置，就不做改变
 * 这样做的目的是尽最大可能把数组中元素按照下标排序好
 * 然后从1开始遍历，找数组中1-1=0位置的元素是不是1，依次找2、3、4，一直找到数组长度len为止，因为数组长度为len，其中没出现的最小正整数
 * 最大也不超过len+1，比如[4,5,6]，这种明显最小正整数是1，再比如[1,2,3,4,5]，这样数组中元素没有跳跃时的最小正整数是6,也就是len + 1
 * @Author: chong
 * @Data: 2021/8/17 4:36 下午
 */
public class MySolution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        // 进行原地哈希
        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        // 从第一个最小的正整数1开始找是不是在数组中，没在就返回
        for (int i = 1; i <= len; i++){
            if (nums[i - 1] != i){
                return i;
            }
        }

        // 最后如果都在数组中，那么只剩len + 1
        return len + 1;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
