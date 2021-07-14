package removeNthFromEnd_19;

import jdk.nashorn.internal.runtime.RewriteException;
import org.junit.Test;
import utils.ListNode;


/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/7 10:37 下午
 */
public class MySolution {
    public ListNode removeNthFromEnd(ListNode head, int n){
//        设置两个快慢指针
        ListNode first;
        ListNode last;
//        设置前驱的辅助节点pre
        ListNode pre = new ListNode(0);
//        分别把慢指针设置在pre上，快指针设置在head上，把head接在pre的后面
        pre.next = head;
        last = pre;
        first = head;
        while (first != null){
            first = first.next;
//            当快指针开始往前走了n步之后，慢指针也该开始走了
            if (n <= 0)
                last = last.next;
            n--;
        }
//        最后干掉慢指针后面的节点就成功删除了倒数第n个节点
        last.next = last.next.next;
        return pre.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(head, 2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
