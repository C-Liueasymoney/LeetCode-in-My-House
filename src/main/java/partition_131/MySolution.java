package partition_131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 3:34 下午
 */
public class MySolution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        process(s, 0, new ArrayList<>());
        return res;
    }

    public void process(String s, int start, List<String> list){
        if (start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++){
            String temp = s.substring(start, i);
            if (isP(temp)){
                list.add(temp);
                process(s, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isP(String s){
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        List<List<String>> res = partition("efe");
        System.out.println(res);
    }
}
