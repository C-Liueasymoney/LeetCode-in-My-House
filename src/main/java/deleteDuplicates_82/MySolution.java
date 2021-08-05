package deleteDuplicates_82;

import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/23 6:48 下午
 */
public class MySolution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode prev = dummyHead;
        int count = 1;
        int val = head.val;

        while (cur != null){
            cur = cur.next;
            if (cur != null){
                if (cur.val != val){
                    if (count > 1){
                        prev.next = cur;
                    }else {
                        prev = prev.next;
                    }
                    val = cur.val;
                    count = 1;
                }else {
                    count++;
                }
            }
        }

        if (count > 1){
            prev.next = cur;
        }
        return dummyHead.next;
    }
}
