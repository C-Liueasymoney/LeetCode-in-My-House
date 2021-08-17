package MyStack_225;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 2:03 下午
 */
public class MySolution {
    // 搞两个队列
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    // 搞一个常数保存栈顶元素
    int topElement;
    public MySolution(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // push操作，队列1直接入队，并且记录下x作为此时堆顶元素
        queue1.offer(x);
        topElement = x;   // 每次记录队尾元素，也就是栈顶元素
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // pop操作，首先把队列1中的元素出队并入队到队列2中（除了最后一个元素，即堆顶元素）
        int result = -1;
        int size = queue1.size();
        while (size > 1) {
            // 队列1还剩2个元素的时候，把第二个记录为堆顶元素
            if (size == 2){
                topElement = queue1.peek();
            }
            queue2.offer(queue1.poll());
            size--;
        }
        // 删掉队列中最后一个元素，即堆顶元素
        result = queue1.poll();
        // 交换一下指针指向，这样可以使得队列1一直是保存元素的那个队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }


    @Test
    public void test(){
        MySolution mySolution = new MySolution();
        mySolution.push(1);
        mySolution.pop();
        mySolution.top();
    }
}
