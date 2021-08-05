package nextGreaterElement_496;

import org.junit.Test;

import java.awt.image.RescaleOp;
import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/14 3:28 下午
 */
public class MySolution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存放最后的结果，即nums1中的元素在nums2中对应的右边第一个大数
        int[] res = new int[nums1.length];
        // 存放中间数组，就是nums2数组中每个元素其右边第一个大数的下标
        int[] bValue = new int[nums2.length];
        // 自底向上递减单调栈
        Deque<Integer> stack = new LinkedList<>();
        // map用来保存nums2数组中元素与对应数组下标的映射，以便于在最后使用nums1数组元素查找
        Map<Integer, Integer> map = new HashMap<>(nums2.length);


        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);   // key：数组元素 value：对应数组下标
            // 单调栈非空，且栈顶元素要小于新加入的元素，就要弹出栈顶元素，同时把栈顶元素的右手第一大记作当前下标i
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                bValue[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){   // 最后清算栈中剩余元素，能剩下来的都是因为右手边没有比它更大的了，所以都设置为-1
            bValue[stack.pop()] = -1;
        }

        for (int i = 0; i < nums1.length; i++){   // 把nums2得到的结果用nums1中元素查找
            res[i] = bValue[map.get(nums1[i])] == -1 ? -1 : nums2[bValue[map.get(nums1[i])]];
        }
        return res;
    }

    @Test
    public void test(){
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(num1, num2);
        System.out.println(Arrays.toString(res));
    }
}
