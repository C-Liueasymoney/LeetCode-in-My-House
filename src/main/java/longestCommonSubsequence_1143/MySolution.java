package longestCommonSubsequence_1143;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/8/12 5:42 下午
 */
public class MySolution {
    public int longestCommonSubsequence(String text1, String text2) {
        return process(text1, text2, 0, 0);
    }

    public int process(String text1, String text2, int index1, int index2){
        if (index1 == text1.length() || index2 == text2.length()){
            return 0;
        }

        int len = 0;

        if (text1.charAt(index1) == text2.charAt(index2)){
            len += process(text1, text2, index1 + 1, index2 + 1) + 1;  // 表示找到了一个相同位置
        }else {
            len += Math.max(process(text1, text2, index1 + 1, index2),
                    process(text1, text2, index1, index2 + 1));   // 做两个选择，text1或者text2后移，累加得到的较大值
        }
        return len;
    }

    @Test
    public void test() {
        int res = longestCommonSubsequence("abc", "def");
        System.out.println(res);
    }
}
