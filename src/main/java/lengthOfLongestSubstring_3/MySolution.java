package lengthOfLongestSubstring_3;

import org.junit.Test;
import sun.tools.jconsole.MaximizableInternalFrame;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/4 4:06 下午
 */
public class MySolution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        // 使用hashMap保存字符串中出现的字符以及其数组下标
        Map<Character, Integer> map = new HashMap<>();
        // 设定左右指针
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()){
            // 检查map中是否已经出现此元素
            if (map.containsKey(s.charAt(right))){
                // 出现此元素就将left指针设定为上一次出现此元素的下一个位置
                // 注意加上max的原因是因为不能让left回退，比如字符串"abba"，如果没有max判断
                // left从0先跳到3，此时检测到a出现过，如果跳到上次出现a的下一个位置1就会出现错误，因为此时子字符串中还包含相同的两个'b'
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            // 更新字符的信息
            map.put(s.charAt(right), right);
            result = Math.max((right - left) + 1, result);
            right++;
        }
        return result;
    }

    @Test
    public void test(){
        int res = lengthOfLongestSubstring("abba");
        System.out.println(res);
    }
}
