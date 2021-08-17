package rotateRight_61;

import org.junit.Test;
import utils.ListNode;

import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/6 3:09 下午
 */
public class MySolution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = head;

        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }

        k %= len;
        if (k == 0)
            return head;
        ListNode temp = dummy;
        int index = len - k;
        while (index > 0){
            temp = temp.next;
            index--;
        }

        tail.next = head;
        dummy.next = temp.next;
        temp.next = null;

        return dummy.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = rotateRight(head, 2);
        System.out.println(res.val);
    }
}
