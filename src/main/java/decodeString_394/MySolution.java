package decodeString_394;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Description:
 * 辅助栈方法
 * @Author: chong
 * @Data: 2021/8/7 4:34 下午
 */
public class MySolution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;

        int num = 0;
        StringBuilder res = new StringBuilder();
        LinkedList<Node> stack = new LinkedList<>();


        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '['){   // 把当前的num和res打包入栈,并且重置
                Node node = new Node(num, res.toString());
                stack.push(node);
                num = 0;
                res = new StringBuilder();
            }else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = num * 10 + (s.charAt(i) - '0');    // 要考虑到数字为两位以上的情况
            }else if (s.charAt(i) == ']'){   // 弹出栈中node，用其中nums乘上现有的res，并拼接在node.str后面
                Node n = stack.pop();
                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < n.num; k++){
                    temp.append(res);
                }
                res = new StringBuilder(n.str).append(temp);
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    static class Node{
        int num;
        String str;

        public Node(int num, String str) {
            this.num = num;
            this.str = str;
        }
    }


    @Test
    public void test(){
        String res = decodeString("3[a2[c]]");
        System.out.println(res);
    }
}
