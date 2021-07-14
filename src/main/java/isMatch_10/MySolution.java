package isMatch_10;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/5 4:46 下午
 */
public class MySolution {
    public boolean isMatch(String s, String p){
//        空字符串可以匹配，所以需要建立length+1的数组空间
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        初始条件
        dp[0][0] = true;
//        i必须要遍历0，因为可能s为空的情况下，p如"a*"也可以匹配
//        j不用遍历0，因为如果j=0除了i=0其他情况都不能匹配
        for (int i = 0; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
//                检查p中当前位是否为*，不是的话就可以进行按位的匹配
                if (p.charAt(j - 1) != '*'){
//                    如果对应位相等，就根据转移方程将前一位结果转移过来
                    if (matches(s, p, i, j))
                        dp[i][j] = dp[i - 1][j - 1];
//                    对应位不相等，可以直接判断位false
                    else
                        dp[i][j] = false;
//                    p中当前位为*的情况
                }else {
//                    注意这里因为p中当前为是*，所以要判断*之前的一位是否与s当前位相等
                    if (matches(s, p, i, j - 1))
//                        表示*之前的字母可以匹配多位也可以只匹配0位（那个为true就选择哪个）
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    else
//                        表示*之前的字母出现0次
                        dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean matches(String s, String p, int i, int j){
//        i=0代表s为空串，肯定不会直接match
        if (i == 0)
            return false;
//        注意因为j是从0开始的，所以确定对应的数组下标要减1
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Test
    public void test(){
        String s = "aa";
        String p = "a*";
        boolean res = isMatch(s, p);
        System.out.println(res);
    }
}
