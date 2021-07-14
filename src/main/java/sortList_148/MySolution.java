package sortList_148;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/23 9:47 上午
 */
public class MySolution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail)
                fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode pre = new ListNode(-1);
        ListNode tail = pre;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            }else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a != null)
            tail.next = a;
        if (b != null)
            tail.next = b;
        return pre.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode res = sortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
