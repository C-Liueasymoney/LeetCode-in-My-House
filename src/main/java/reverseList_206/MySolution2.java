package reverseList_206;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * 递归法
 * @Author: chong
 * @Data: 2021/6/23 4:44 下午
 */
public class MySolution2 {
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode res = reverseList(head.next);
//        保证每次实现局部的两个节点指向反转
        head.next.next = head;
//        断掉原来的指向
        head.next = null;
        return res;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode res = reverseList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
