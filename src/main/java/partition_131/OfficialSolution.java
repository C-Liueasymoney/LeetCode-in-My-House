package partition_131;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 4:33 下午
 */
public class OfficialSolution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // 预处理数组，用来保存i到j区间到字符子串是否是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length() * 2 - 1; i++){
            int left = i / 2;
            int right = left + i % 2;
            preDo(s, left, right, dp);
        }

        process(s, 0, new ArrayList<>(), dp);
        return res;
    }

    public void process(String s, int start, List<String> list, boolean[][] dp){
        if (start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++){
            String temp = s.substring(start, i);
            if (dp[start][i - 1]){
                list.add(temp);
                process(s, i, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }


    // 使用中心扩散法来判断回文子串
    public void preDo(String s, int left, int right, boolean[][] dp){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            dp[left][right] = true;
            left--;
            right++;
        }
    }

    @Test
    public void test(){
        List<List<String>> res = partition("efe");
        System.out.println(res);
    }
}
