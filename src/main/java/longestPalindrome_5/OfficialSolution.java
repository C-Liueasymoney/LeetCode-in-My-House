package longestPalindrome_5;

import org.junit.Test;



/**
 * @Description:
 * 动态规划
 * @Author: chong
 * @Data: 2021/6/5 2:16 下午
 */
public class OfficialSolution {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];

//        为处于对角线的子串长度为1的dp[i][i]赋初始值为true
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // 设置最后返回结果的子串初始位置和最大长度
        int begin = 0;
        int maxLength = 1;
        // 要先从小长度开始遍历填充dp数组，否则会导致dp[i+1][j-1]取到还没初始化的值
        // 从L=2开始，因为长度为1的已经在上面的循环中初始化好了
        for (int L = 2; L <= s.length(); L++){
            for (int i = 0; i < s.length(); i++){
//                利用长度来定位j的位置
                int j = i + L - 1;
                // j越过右边界的话就可以直接跳出当前循环了
                if (j >= s.length())
                    break;
//                发现两端字符不等直接可以填入false了
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
//                    包括子串长度为2和为3的情况，这两种情况在确定了两端元素相等的情况下可以直接判断为回文串
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];   // 此时由于是从短子串遍历到长子串因此不会导致填入未初始化的值
                }
//                替换最长的回文串满足两个条件：1、dp[i][j] == true，即s[i:j]首先是一个回文串
//                2、j - i + 1 > maxLength 即字串的长度要大于当前最大的回文子串长度
                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    @Test
    public void test(){
        String s = "aaaa";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
