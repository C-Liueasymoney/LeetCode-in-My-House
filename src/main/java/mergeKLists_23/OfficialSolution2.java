package mergeKLists_23;

import utils.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/9 12:34 下午
 */
public class OfficialSolution2 {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0)
            return null;
        ListNode pre = new ListNode(-1);
        ListNode tail = pre;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists){
            if (list != null)
                heap.offer(list);
        }
        while (!heap.isEmpty()){
            ListNode temp = heap.poll();
            tail.next = temp;
            if (temp.next != null)
                heap.offer(temp.next);
            tail = tail.next;
        }
        return pre.next;
    }
}
