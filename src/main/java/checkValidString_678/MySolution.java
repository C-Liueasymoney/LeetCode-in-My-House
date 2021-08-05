package checkValidString_678;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/28 3:30 下午
 */
public class MySolution {
    public boolean checkValidString(String s) {
        // low和high分别代表遍历过程中出现的未匹配的左括号的最大数量,以及加上*的数量
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){   // 左括号肯定要先出现，后面才会判断有无匹配，所以这里直接++
                low++;
                high++;
            }else if (s.charAt(i) == ')'){  // 这里指如果'('用完了，用'*'顶上来
                if (low > 0){
                    low--;
                }
                high--;
            }else if (s.charAt(i) == '*'){
                if (low > 0){
                    low--;
                }
                high++;
            }
            if (high < 0){
                return false;
            }
        }
        return low == 0;
    }


    @Test
    public void test(){
        boolean res = checkValidString("((((*))");
        System.out.println(res);
    }

}
