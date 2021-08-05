package reverseBetween_92;

import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/23 5:04 下午
 */
public class MySolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)  // left = right说明不用反转了
            return head;

        ListNode tail = head;
        ListNode prev = null;
        while (left > 1){    // 先到达开始反转链表的位置
            prev = tail;
            tail = tail.next;
            left--;
            right--;
        }

        ListNode startPrev = prev;
        ListNode start = tail;    // 记录下链表开始反转的节点

        // 如果不是从第一个节点开始反转，就先完成第一步的反转，其中要多一步prev.next = null
        if (prev != null) {
            ListNode temp = tail.next;
            prev.next = null;
            tail.next = prev;
            prev = tail;
            tail = temp;
            right--;
        }

        while (right > 0){
            ListNode temp = tail.next;
            tail.next = prev;
            prev = tail;
            tail = temp;
            right--;
        }

        // 最后利用之前保存的start节点，和当前停在结束位置的prev、tail节点完成排列
        if (start == head){
            head.next = tail;
            return prev;
        }else {
            start.next = tail;
            startPrev.next = prev;
            return head;
        }
    }
}
