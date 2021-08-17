package reverseKGroup_25;

import org.junit.Test;
import utils.ListNode;

import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/6 5:07 下午
 */
public class MySolution {
    // 利用递归思想，翻转一组后，把后面的链表作为子问题，继续调用reverseKGroup翻转下面的一组
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        int count = k;

        while (count > 0 && cur != null){
            cur = cur.next;
            count--;
        }
        if (count != 0){   // base case，说明最后一部分节点数量不足k个，不用翻转直接返回
            return head;
        }
        // 递归调用，以此次调用中未翻转的部分作为下次翻转的头,返回的就应该是翻转后的头节点，把它拼接到此次翻转的尾节点（即老head）后即可
        ListNode next = reverseKGroup(cur, k);

        ListNode newHead = reverse(head, cur);   // 翻转此范围的节点，得到翻转后的新头节点
        head.next = next;

        return newHead;
    }

    // 翻转a、b之间（左闭右开）的链表
    public ListNode reverse(ListNode a, ListNode b){
        ListNode cur = a;
        ListNode temp = null;
        while (cur != b){
            ListNode next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
        }

        // 最后返回翻转后的头节点
        return temp;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(head, 2);
        System.out.println(res.val);
    }
}
