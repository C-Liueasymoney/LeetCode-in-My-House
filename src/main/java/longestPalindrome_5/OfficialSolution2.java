package longestPalindrome_5;

/**
 * @Description:
 * 中心扩散法
 * @Author: chong
 * @Data: 2021/7/13 7:41 下午
 */
public class OfficialSolution2 {
    public String longestPalindrome(String s) {
        String res = "";
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
}
