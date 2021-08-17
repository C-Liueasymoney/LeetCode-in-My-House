package addStrings_415;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/11 4:51 下午
 */
public class MySolution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0){
            return "";
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int c = 0;
        while (i >= 0 || j >= 0){
            int a = 0;
            int b = 0;
            if (i >= 0){
                a = num1.charAt(i) - '0';
            }
            if (j >= 0){
                b = num2.charAt(j) - '0';
            }
            res.append((a + b + c) % 10);
            c = (a + b + c) / 10;
            i--;
            j--;
        }
        if (c != 0){
            res.append("1");
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        String res = addStrings("584", "18");
        System.out.println(res);

    }
}
