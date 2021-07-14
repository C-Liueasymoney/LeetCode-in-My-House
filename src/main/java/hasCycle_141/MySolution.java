package hasCycle_141;

import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 3:05 下午
 */
public class MySolution {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;
//        设置快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
