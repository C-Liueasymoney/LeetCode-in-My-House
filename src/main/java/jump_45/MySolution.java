package jump_45;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/28 6:27 下午
 */
public class MySolution {
    public int jump(int[] nums) {
        int res = 0;
        // 分别记录起跳点和最大跳跃距离，start和end共同确定了一个范围（左闭右闭），在这个范围内的元素都算作一步
        // 因为这个范围是根据上一跳确定下来的，所以只要在这个范围内，都是可以通过上一跳得到
        int start = 0;
        int end = 0;

        while (end < nums.length - 1){  // 当最大跳跃距离跳到了比数组最后元素下标大或等于的位置，即完成跳跃
            int temp = end;     // 记录下当前的最大距离end位置，因为后面end会更新

            for (int i = start; i <= temp; i++){   // 遍历起跳点和最大跳跃距离之间的元素，更新start和end
               end = Math.max(end, i + nums[i]);
            }
            start = temp + 1;   // 下一跳的start是这一跳end更新前的下一位，因为这一跳最多跳到end位置，那下一跳要从end+1开始跳
            res++;    // 每一个while循环相当于跳了一步，res++
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {2, 3, 0, 1, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
