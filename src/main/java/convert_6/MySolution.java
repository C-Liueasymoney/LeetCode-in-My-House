package convert_6;

import org.junit.Test;

/**
 * @Description:
 * 找规律题
 * @Author: chong
 * @Data: 2021/8/12 4:50 下午
 */
public class MySolution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder res = new StringBuilder();

        int index = 0;
        while (index < s.length()){
            res.append(s.charAt(index));
            index += (numRows - 1) * 2;  // 规律 第一行和最后一行
        }

        // 处理中间行，如果有的话(numRows=2没有)
        for (int i = 1; i < numRows - 1; i++){
            index = i;
            while (index < s.length()){
                res.append(s.charAt(index));
                index += (numRows - 1 - i) * 2;
                if (index >= s.length()){  // 再次判断
                    break;
                }
                res.append(s.charAt(index));
                index += i * 2;
            }
        }

        // 处理最后一行，规律和第一行一样
        index = numRows - 1;
        while (index < s.length()){
            res.append(s.charAt(index));
            index += (numRows - 1) * 2;
        }
        return res.toString();
    }

    @Test
    public void test() {
        String res = convert("PAYPALISHIRING", 4);
        System.out.println(res);
    }
}
