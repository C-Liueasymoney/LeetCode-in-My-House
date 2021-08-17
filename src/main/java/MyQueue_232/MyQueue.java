package MyQueue_232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 *     // 均摊时间复杂度应该还是O(N)
 *     因为虽然pop和peek操作都要操作栈1和栈2，但是显然一个元素最多只会被从栈1转移到栈2一次
 * @Author: chong
 * @Data: 2021/8/14 5:04 下午
 */
public class MyQueue {
    // 准备两个栈
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 元素入队的时候，直接压入栈1
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 元素要弹出了，首先判断栈2是否为空，不为空直接弹出，就是队首元素
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        // 栈2为空，说明之前的pop操作加入的元素已经弹完了，把栈1的元素弹出压入栈2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // peek操作依旧是栈2不为空就返回栈2堆顶元素
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        // 栈2为空，还是压入栈1元素
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
