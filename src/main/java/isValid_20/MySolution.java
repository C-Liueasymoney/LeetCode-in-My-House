package isValid_20;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/8 8:52 上午
 */
public class MySolution {
    public boolean isValid(String s){
        if (s.length() % 2 != 0)
            return false;
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stack.isEmpty() && isMatch(stack.peek(), aChar))
                stack.pop();
            else
                stack.push(aChar);
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char a, char b){
        return a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']';
    }

    @Test
    public void test(){
        boolean res = isValid("([)]");
        System.out.println(res);
    }
}
