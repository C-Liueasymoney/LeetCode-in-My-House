package trap_42;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Description:
 *  单调栈方法，维护一个从栈顶到栈底递增的单调栈，借助它判断雨水
 * @Author: chong
 * @Data: 2021/6/11 9:58 下午
 */
public class OfficialSolution_2 {
    public int trap(int[] height){
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int current = 0;
        while (current < height.length){
//            做新元素入栈判断，如果栈不为空且栈顶元素小于新元素就不断弹出栈顶元素，反之新元素入栈
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                // 代表bottom，也就是这个小容器的底部高度
                int h = height[stack.pop()];
                // 如果弹出前一个元素导致栈空了，那就不用算了，这个位置无法接到雨水
                if (stack.isEmpty())
                    break;
//                计算当前元素与上上个元素位置的距离，注意这里中间隔着若干元素
                int distance = current - stack.peek() - 1;
                // 当前位置和再前位置的高度最小值，也就是说这个容器的短板
                int min = Math.min(height[current], height[stack.peek()]);
                res += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return res;
    }

    @Test
    public void test(){
        int[] height = {4,2,0,3,2,5};
        int res = trap(height);
        System.out.println(res);
    }
}
