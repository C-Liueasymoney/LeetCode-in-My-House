package mergeKLists_23;

import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/8 10:19 下午
 */
public class MySolution {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode result = null;
        for (int i = 0; i < lists.length; i++){
            result = mergeTwo(result, lists[i]);
        }

        return result;
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


    @Test
    public void test(){
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode res = mergeKLists(lists);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
