package canPartition_416;

import org.junit.Test;

/**
 * @Description:
 * 记忆化搜索
 * @Author: chong
 * @Data: 2021/7/21 7:04 下午
 */
public class MemoryMethod {
    public boolean canPartition(int[] nums) {
        // 这里可以把问题简化，找到能不能分成两个和相等的子集合，也就是说，两个子集合的和就等于数组和的一半
        // 那直接找数组中有没有子集元素和等于数组一般即可，并且数组和如果是奇数可以直接返回false。
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        sum = sum / 2;
        int[][] memory = new int[nums.length][sum + 1];
        return process(nums, 0, sum, memory);
    }


    /**
     * index指定的数组下标，可以有两种选择：1、选择加上此元素2、选择不加，target会减少
     * @param nums 固定参数
     * @param index 可变参数，代表遍历到的nums数组元素下标
     * @param target 可变参数，代表当前需要的目标值
     * @return
     */
    public boolean process(int[] nums, int index, int target, int[][] memory){
        if (index == nums.length){   // base case，数组全部元素已经选择完成，总和有没有正好到达target（即把target减到0）
            return target == 0;
        }

        if (target < 0){
            return false;
        }

        if (memory[index][target] != 0){
            return memory[index][target] == 1;
        }

        // 代表两种选择：1、当前index位置我不减，说明这个子集我把nums[index]算在内；2、我减，把nums[index]算在内
        memory[index][target] =  (process(nums, index + 1, target, memory) |
                process(nums, index + 1, target - nums[index], memory)) ? 1 : -1;

        return memory[index][target] == 1;
    }


    @Test
    public void test(){
        int[] nums = {1, 5, 11, 5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
}
