package reverseBetween_92;

import utils.ListNode;

/**
 * @Description:
 * 头插法+双指针
 * @Author: chong
 * @Data: 2021/7/23 5:53 下午
 */
public class OfficialSolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 设置初始化双指针
        ListNode prev = dummyHead;
        ListNode last = dummyHead.next;

        for (int i = 0; i < left - 1; i++){   // 移动双指针到初始位置
            prev = prev.next;
            last = last.next;
        }

        for (int i = 0; i < right - left; i++){
            ListNode nextNode = last.next;
            last.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummyHead.next;
    }
}
