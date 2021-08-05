package deleteDuplicates_83;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/23 10:36 下午
 */
public class MySolution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode prev = dummyHead;

        while (cur != null){
            if (prev.val == cur.val){
                ListNode temp = cur.next;
                prev.next = temp;
                cur = temp;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(-1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(0);

        ListNode node = deleteDuplicates(head);
        System.out.println(node.val);
    }
}
