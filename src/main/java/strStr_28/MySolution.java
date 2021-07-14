package strStr_28;


import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/11 4:31 下午
 */
public class MySolution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;

        char[] strS = haystack.toCharArray();
        char[] strP = needle.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(strP);

        while (i1 < strS.length && i2 < strP.length){
            if (strS[i1] == strP[i2]){
                i1++;
                i2++;
            } else if (next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == strP.length ? i1 - i2 : -1;
    }


    public int[] getNext(char[] strP){
        if (strP.length == 1)
            return new int[]{-1};
        int[] next = new int[strP.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length){
            if (strP[i - 1] == strP[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }


    @Test
    public void test(){
        String strS = "hello";
        String strP = "ll";
        int res = strStr(strS, strP);
        System.out.println(res);
    }
}
