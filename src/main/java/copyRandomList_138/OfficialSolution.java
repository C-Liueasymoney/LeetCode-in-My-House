package copyRandomList_138;

import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;
import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import utils.Node;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 10:06 上午
 */
public class OfficialSolution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        Node next = null;
//        第一次遍历创建出新节点并穿插进旧链表中
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
//        第二次循环要把新节点的random指向旧节点对应random的next位置（就是应该指向的地方）
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
//        第三次遍历把新节点剥离出来
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
