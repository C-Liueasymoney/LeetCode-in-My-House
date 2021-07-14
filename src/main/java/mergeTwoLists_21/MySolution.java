package mergeTwoLists_21;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/8 9:32 上午
 */
public class MySolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
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

        while (l1 != null){
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null){
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        return pre.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode res = mergeTwoLists(l1, l2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
