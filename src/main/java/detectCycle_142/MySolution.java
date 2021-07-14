package detectCycle_142;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 3:14 下午
 */
public class MySolution {
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
//        使用快慢指针判断链表是否有环
        while (slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || fast.next == null)
                return null;
            if (slow == fast)
                break;
        }

//        如果链表有环进行到这一步，此时快慢指针相遇，把快指针调整到头节点的位置，重新开始遍历，这次两个指针每次都只走一步
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next;
        ListNode res = detectCycle(head);
        System.out.println(res.val);
    }
}
