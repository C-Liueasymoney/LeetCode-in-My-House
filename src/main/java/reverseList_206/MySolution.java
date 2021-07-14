package reverseList_206;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * 迭代三指针法
 * @Author: chong
 * @Data: 2021/6/23 4:26 下午
 */
public class MySolution {
    public ListNode reverseList(ListNode head){
        ListNode preNode = head;
        ListNode latterNode = null;
        while (preNode != null){
            ListNode temp = preNode.next;
            preNode.next = latterNode;
            latterNode = preNode;
            preNode = temp;
        }
        return latterNode;
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
