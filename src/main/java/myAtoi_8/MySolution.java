package myAtoi_8;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/3 5:12 下午
 */
public class MySolution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        boolean negative = false;
        boolean sign = false;
        boolean number = false;

        for (int i = 0; i < chars.length; i++){
            if (isNumber(chars[i])){
                number = true;
                if (!negative && ((res > 214748364) || (res == 214748364 && chars[i] > '7'))){
                    return Integer.MAX_VALUE;
                }

                if (negative && ((res > 214748364) || (res == 214748364) && chars[i] > '8')){
                    return Integer.MIN_VALUE;
                }

                res = res * 10 + charToNumber(chars[i]);

            }else if (!number && chars[i] == ' '){
                continue;
            } else if (!number && !sign && (i + 1 < chars.length) && isNumber(chars[i + 1]) && chars[i] == '+'){
                sign = true;
            }else if (!number && !sign && !negative && (i + 1 < chars.length) && isNumber(chars[i + 1]) && chars[i] == '-'){
                negative = true;
            }else {
                break;
            }
        }
        return negative ? -res : res;
    }


    public boolean isNumber(char i){
        return i >= '0' && i <= '9';
    }

    public int charToNumber(char i){
        return i - '0';
    }

    @Test
    public void test(){
        int res = myAtoi("  +  413");
        System.out.println(res);
    }
}
