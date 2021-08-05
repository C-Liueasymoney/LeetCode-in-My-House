package dailyTemperatures_739;

import java.nio.file.StandardWatchEventKinds;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/15 10:22 下午
 */
public class MySolution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                // 不同之处，就在于结果保存的是右手大数距离此位置的距离
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result[stack.pop()] = 0;
        }

        return result;
    }
}
