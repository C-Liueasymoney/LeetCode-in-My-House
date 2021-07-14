package maxSumMinProduct_1856;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * 单调栈、前缀和
 * @Author: chong
 * @Data: 2021/7/14 2:17 下午
 */
public class MySolution {
    public int maxSumMinProduct(int[] nums) {
        // 构造出前缀和
        long[] dp = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        // 分别用两个数组来保存nums中每个位置上左边和右边第一个小于值的下标
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // 单调栈
        Deque<Integer> stack = new LinkedList<>();

        // 先查找右边边界
        for (int i = 0; i < nums.length; i++){
            // 在栈顶元素比当前元素大的时候，确定右边界无法再扩张，把栈中元素依次弹出并记录它们的右边界就是i - 1（当前元素前一位）
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                right[stack.pop()] = i - 1;
            }
            stack.push(i);
        }
        // 最后把栈中剩余元素清算
        while (!stack.isEmpty()){
            // length - 1代表nums中最右元素下标，栈中最后剩下的元素都是因为右边没有更小的元素，所以可以把整个右边作为子数组
            right[stack.pop()] = nums.length - 1;
        }

        // 查找nums每个元素的左边界
        for (int i = nums.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        // 清算
        while (!stack.isEmpty()){
            left[stack.pop()] = 0;
        }

        long res = 0L;

        for (int i = 0; i < nums.length; i++){
            res = Math.max(res, (dp[right[i] + 1] - dp[left[i]]) * nums[i]);
        }
        return (int) (res % 1000000007);
    }

    @Test
    public void test(){
        int[] nums = {3,1,5,6,4,2};
        int res = maxSumMinProduct(nums);
        System.out.println(res);
    }
}
