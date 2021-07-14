package generateParenthesis_22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/8 9:50 下午
 */
public class OfficialSolution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        recur(new StringBuilder(), n, n);
        return result;
    }

    public void recur(StringBuilder str, int left, int right){
        if (left == 0 && right == 0){
            result.add(str.toString());
            return;
        }

        if (left > right)
            return;

        if (left > 0){
            str.append("(");
            recur(str, left - 1, right);
            str.deleteCharAt(str.length() - 1);
        }

        if (right > 0){
            str.append(")");
            recur(str, left, right - 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
    @Test
    public void test(){
        List<String> res = generateParenthesis(1);
        System.out.println(res);
    }
}
