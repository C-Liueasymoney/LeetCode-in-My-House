package numDecodings_91;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/8/15 3:12 下午
 */
public class MySolution {
    public int numDecodings(String s) {
        return process(s, 0);
    }

    public int process(String s, int index){
        if (index == s.length()){
            return 1;
        }

        int res = 0;
        for (int i = index; i < Math.min(index + 2, s.length()); i++){
            if (s.charAt(index) != '0'){
                int num = Integer.parseInt(s.substring(index, i + 1));
                if (num > 0 && num <= 26){
                    res += process(s, i + 1);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int res = numDecodings("226");
        System.out.println(res);
    }
}
