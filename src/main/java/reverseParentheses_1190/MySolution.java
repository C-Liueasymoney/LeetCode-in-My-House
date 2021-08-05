package reverseParentheses_1190;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/4 9:04 下午
 */
public class MySolution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        int index = 0;
        while (index < s.length()){
            char c = s.charAt(index);
            if (c == '('){
                stack.push(sb.toString());
                sb = new StringBuilder();
            }else if (c == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            }else {
                sb.append(c);
            }
            index++;
        }

        return sb.toString();
    }

    @Test
    public void test(){
        String res = reverseParentheses("(u(love)i)");
        System.out.println(res);
    }
}
