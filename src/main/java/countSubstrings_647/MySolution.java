package countSubstrings_647;

/**
 * @Description:
 * 中心扩散法
 * @Author: chong
 * @Data: 2021/7/12 9:41 下午
 */
public class MySolution {
    public int countSubstrings(String s) {
        int res = 0;   // s字符串中有多少个回文串
        int len = s.length() * 2 - 1;   // s中有多少个中心点，中心点可以用字符串中的一个字符做，也可以把两个连续的字符作为一个中心点

        for (int i = 0; i < len; i++){  // 遍历每一个中心点
            int left = i / 2;     // 表示当前中心点的起始下标，比如"abc",第二个中心点是"ab",起始下标就是 1 / 2 = 0 -> "a"
            int right = left + i % 2;    // 表示当前中心点的终止下标，还是上面的例子，终止下标是0 + 1 % 2 = 1 -> "b"

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
