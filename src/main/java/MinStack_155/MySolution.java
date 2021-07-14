package MinStack_155;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/7 6:17 下午
 */
public class MySolution {
    LinkedList<Integer> stack;
    LinkedList<Integer> auxStack;

    public MySolution(){
        stack = new LinkedList<>();
        auxStack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(val);
            auxStack.push(val);
        } else {
            auxStack.push(Math.min(auxStack.peek(), val));
            stack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        auxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxStack.peek();
    }
}
