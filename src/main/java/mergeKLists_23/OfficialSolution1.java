package mergeKLists_23;

import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 12:24 下午
 */
public class OfficialSolution1 {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwo(l1, l2);
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(-1);
        ListNode tail = pre;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;
        return pre.next;
    }
}
