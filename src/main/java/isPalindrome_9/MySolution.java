package isPalindrome_9;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/3 7:46 下午
 */
public class MySolution {
    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        if (xStr.charAt(0) == '-')
            return false;

        int left = (xStr.length() - 1) / 2;
        int right = xStr.length() / 2;

        while (left >= 0 && right < xStr.length()){
            if (xStr.charAt(left) == xStr.charAt(right)){
                left--;
                right++;
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        boolean res = isPalindrome(10);
        System.out.println(res);
    }
}
