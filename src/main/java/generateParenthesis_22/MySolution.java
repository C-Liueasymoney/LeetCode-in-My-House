package generateParenthesis_22;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/8 1:47 下午
 */
public class MySolution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        recur(2 * n, new StringBuilder(), "(");
        return result;
    }

    public void recur(int n, StringBuilder ele, String p){
        ele.append(p);
        if (n <= 1) {
            if (isParenthesis(ele))
                result.add(ele.toString());
            ele.deleteCharAt(ele.length() - 1);
            return;
        }
        n--;
        recur(n, ele, "(");
        recur(n, ele, ")");
        ele.deleteCharAt(ele.length() - 1);
    }

    public boolean isParenthesis(StringBuilder ele){
        LinkedList<Character> stack = new LinkedList<>();
        for (char e : ele.toString().toCharArray()){
            if (stack.isEmpty() && e == ')')
                return false;
            if (!stack.isEmpty() && (stack.peek() == '(' && e == ')'))
                stack.pop();
            else
                stack.push(e);
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        List<String> res = generateParenthesis(4);
        System.out.println(res);
    }
}
