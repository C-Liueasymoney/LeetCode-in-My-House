package minWindow_76;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/21 9:14 上午
 */
public class MySolution {
    public String minWindow(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
//        count作为当时还需要多少的对应字符个数
        int count = t.length();
//        resCount是初始结果的最大长度，最大也不会超过s的长度
        int resCount = s.length();
        String res = "";
//        用map保存t中所有字母以及其出现的次数
        for (int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
//        right指针到达最后停止
        while (right < s.length()){
//            记录左右指针指向位置的字符
            char leftLet = s.charAt(left);
            char rightLet = s.charAt(right);
//            如果map中含有右指针的字符，也就是t中包含
            if (map.containsKey(rightLet)){
//                先把map中对应字符出现的次数减一
                map.put(rightLet, map.get(rightLet) - 1);
//                如果减一后该字符出现次数大于等于0，说明这个字符是被需要的，count--
                if (map.get(rightLet) >= 0)
                    count--;
            }
//            如果count减到了0，说明此时左右指针包含的子字符串已经包含了所有需要的字符
            while (count == 0){
//                因为left要在这个while循环更新，所以设置一下leftLet
                leftLet = s.charAt(left);
//                如果此时left指向的字符包含在t中，且其出现的次数此时大于等于0，说明这个字符拿掉子字符串就不包含全部的t
                if (map.containsKey(leftLet) && map.get(leftLet) >= 0){
//                    此时需要对应字符出现次数加一，总需要字符数也加一
                    count++;
                    map.put(leftLet, map.get(leftLet) + 1);
//                    如果此时子字符串比当前最小结果字符串长度小，就替换最小满足要求的字符串
                    if (resCount >= right - left + 1) {
                        resCount = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
//                    如果left字符在t中，但出现次数小于0，说明拿掉它不会导致子字符串不包含t，那就直接拿掉它，map中对应次数加一
                }else if (map.containsKey(leftLet))
                    map.put(leftLet, map.get(leftLet) + 1);
//                不断右移左指针
                left++;
            }
            right++;
        }
        return res;
    }


    @Test
    public void test(){
        String res = minWindow("ADOBECODEBANC", "ABC");
//        String res = minWindow("a", "a");
        System.out.println(res);
    }
}
