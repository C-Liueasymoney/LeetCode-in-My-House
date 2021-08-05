package reorderList_143;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/22 10:16 下午
 */
public class MySolution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = slow.next;
        slow.next = null;     // 把连接拆掉，防止成环

        revHead = reverse(revHead);

        while (revHead != null){
            ListNode temp = revHead.next;
            revHead.next = head.next;
            head.next = revHead;
            head = revHead.next;
            revHead = temp;
        }

    }

    public ListNode reverse(ListNode head){
        if (head == null){
            return null;
        }

        ListNode tail = head;   // 由于是从中间位置逆转，所以第一次需要拆掉一个指针否则会有环，之后就不用了
        head = head.next;
        tail.next = null;

        while (head != null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);
        System.out.println(head.next.next.next.next.next);

    }
}
