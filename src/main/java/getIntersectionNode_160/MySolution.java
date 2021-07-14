package getIntersectionNode_160;

import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 2:29 下午
 */
public class MySolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null)
            return null;
//        统计A、B链表的长度
        int lenA = 0;
        int lenB = 0;

        ListNode next = headA;
        while (next != null){
            next = next.next;
            lenA++;
        }
        next = headB;
        while (next != null){
            next = next.next;
            lenB++;
        }

//        记录两个链表长度之差
        int step = lenA > lenB ? lenA - lenB : lenB - lenA;
//        较长的链表向前移动和较短的对齐
        if (lenA > lenB) {
            while (step > 0){
                headA = headA.next;
                step--;
            }
        }else {
            while (step > 0){
                headB = headB.next;
                step--;
            }
        }

        while (headA != null){
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
