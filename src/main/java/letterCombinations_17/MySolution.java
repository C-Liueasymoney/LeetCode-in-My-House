package letterCombinations_17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/7 6:49 下午
 */
public class MySolution {
//    用于保存最终结果
    private List<String> result = new ArrayList<>();
    // map用来保存数字到字母的映射
    private static final Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits){
//        边界检查
        if (digits.length() == 0)
            return new ArrayList<>();
//        String temp = "";
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
//        将当前输入的数字如"23"和新创建的StringBuilder（便于对字符串进行改变）输入递归函数
        recur(digits, new StringBuilder());
        return result;
    }

    public void recur(String digits, StringBuilder temp){
//        判断如果digits的长度等于0了，说明已经输完了所有的数字，该返回此时的字符组合了
        if (digits.length() == 0) {
            result.add(temp.toString());
            return;
        }
//        取出当前输入数字的第一位
        char digit = digits.charAt(0);
//        映射出当前数字对应的字符串
        String mapStr = map.get(digit);
//        对映射字符串的每一位做循环
        for (int i = 0; i < mapStr.length(); i++){
//            在temp字符串上加上当前字符串中的一位，然后开启递归，可以让接下来输入数字所对应的字符串都拼接在temp上
            temp.append(mapStr.substring(i, i + 1));
            recur(digits.substring(1), temp);
//            temp = temp.substring(0, temp.length() - 1);
//            别忘记递归出来后删掉temp的最后一位，说明当前的字符已经递归结束
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    @Test
    public void test(){
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);

    }
}
