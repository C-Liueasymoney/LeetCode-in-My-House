package longestPalindromeSubseq_516;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/8/12 8:43 下午
 */
public class MySolution {
    public int longestPalindromeSubseq(String s) {
        return process(s, 0, s.length() - 1);
    }

    public int process(String s, int start, int end){
        if (start == end){
            return 1;
        }
        if (start > end){
            return 0;
        }

        int res = 0;
        if (s.charAt(start) == s.charAt(end)){
            res += process(s, start + 1, end - 1) + 2;
        }else {
            res += Math.max(process(s, start + 1, end), process(s, start, end - 1));
        }

        return res;
    }

    @Test
    public void test() {
        int res = longestPalindromeSubseq("bbbab");
        System.out.println(res);
    }

}
