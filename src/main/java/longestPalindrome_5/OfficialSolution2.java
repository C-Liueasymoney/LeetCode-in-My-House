package longestPalindrome_5;

import org.junit.Test;

/**
 * @Description:
 * 中心扩散法
 * @Author: chong
 * @Data: 2021/7/13 7:41 下午
 */
public class OfficialSolution2 {
    public String longestPalindrome(String s) {
        String res = "";
        // 为了对每个字符做两次扩散，一次是以这个字符，一个是以这个与下一个字符
        int len = s.length() * 2 - 1;

        for (int i = 0; i < len; i++){
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                String temp = s.substring(left, right + 1);
                if (temp.length() > res.length()){
                    res = temp;
                }
                left--;
                right++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        String res = longestPalindrome("bb");
        System.out.println(res);
    }
}
