package restoreIpAddresses_93;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/10 5:07 下午
 */
public class MySolution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        process(s, 0, 0, new StringBuilder());
        return res;
    }

    public void process(String s, int index, int depth, StringBuilder sb){
        if (depth == 4 || index == s.length()){
            if (depth == 4 && index == s.length()){
                StringBuilder sbTemp = new StringBuilder(sb);
                sbTemp.delete(sbTemp.length() - 1, sbTemp.length());// 删掉最后多余的"."
                res.add(sbTemp.toString());
            }
            return;
        }

        // 最长就三位，最多只需要遍历三次
        for (int i = index + 1; i <= Math.min(index + 3, s.length()); i++){
            if (s.charAt(index) == '0'){  // 看第一位是不是0，如果是，直接给下一轮并返回
                sb.append('0').append(".");
                process(s, index + 1, depth + 1, sb);
                sb.delete(sb.length() - 2, sb.length());   // 删掉0.
                break;
            }else {
                String temp = s.substring(index, i);
                int val = Integer.parseInt(temp);
                if (val > 0 && val <= 255){
                    sb.append(temp).append(".");
                    process(s, i, depth + 1, sb);
                    sb.delete(sb.length() - temp.length() - 1, sb.length()); // 注意本轮添加了多少就删几位
                }
            }
        }
    }

    @Test
    public void test(){
        List<String> strings = restoreIpAddresses("101023");
        System.out.println(strings);
    }
}
