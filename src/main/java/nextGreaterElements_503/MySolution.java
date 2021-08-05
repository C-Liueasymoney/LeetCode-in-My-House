package nextGreaterElements_503;

import com.sun.deploy.panel.ExceptionListDialog;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * 循环数组，利用求余构建循环的效果
 * @Author: chong
 * @Data: 2021/7/14 4:14 下午
 */
public class MySolution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Deque<Integer> stack = new LinkedList<>();

        // 将数组扩大一倍，也就是求两轮
        for (int i = 0; i < 2 * nums.length - 1; i++){
            int val = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                res[stack.pop()] = val;
            }
            if (i < nums.length) { // 元素只在第一轮的时候入栈，第二轮只是处理未确定的元素
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            res[stack.pop()] = -1;
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));

    }
}
