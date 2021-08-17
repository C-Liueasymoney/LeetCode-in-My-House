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
        // 比如原来s的长度是4，可取的区间是0~3;那么对应的len是7，可取的区间是0~7，扩大了一倍
        int len = s.length() * 2 - 1;

        for (int i = 0; i < len; i++){
            // 由于区间扩大了一倍，left指针也要变成i / 2，这样会在一个left循环两次
            // 并且right = left + i % 2,就是说在第一次left时，right会和left相等，下一次会比left大1
            // 比如：i = 0 -> left = 0  right = (0 + 0 % 2)=0; i = 1 -> left = 0   right = (0 + 1 % 2)=1
            // 也就代表着第一次是以left为中心来扩散，第二次是以left与left+1为中心扩散
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
