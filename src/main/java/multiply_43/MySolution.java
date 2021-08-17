package multiply_43;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/11 7:54 下午
 */
public class MySolution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0){
            return "";
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }

        StringBuilder zero = new StringBuilder();
        String res = "0";
        for (int i = num1.length() - 1; i >= 0; i--){
            int num = num1.charAt(i) - '0';
            int c = 0;
            StringBuilder multi = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--){
                int m = num * (num2.charAt(j) - '0');
                multi.append((m + c) % 10);
                c = (m + c) / 10;
            }
            if (c != 0){
                multi.append(c);
            }
            res = addStrings(res, multi.reverse().append(zero).toString());
            zero.append("0");
        }

        return res;
    }


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
        String res = multiply("9133", "0");
        System.out.println(res);
    }
}
