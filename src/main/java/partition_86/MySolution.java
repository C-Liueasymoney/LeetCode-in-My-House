package partition_86;

import com.sun.corba.se.impl.encoding.CodeSetConversion;
import org.junit.Test;
import utils.ListNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/24 5:42 下午
 */
public class MySolution {
    public ListNode partition(ListNode head, int x){
        if (head == null || head.next == null)
            return head;
        ListNode sh = null;
        ListNode st = null;
        ListNode bh = null;
        ListNode bt = null;
//        关键步骤：用next保存一下head的下一位，因为后面要把每个head的下一位设null，保证每次每次赋值head赋的都是单个节点
        ListNode next = null;
        while (head != null){
//            先把当前head的下一个节点暂存在next中
            next = head.next;
//            把head下一个节点的指向改为null，防止后面赋值head的时候赋值一大串链表
            head.next = null;
//            head值小于x时，把head添加到sh链表中
            if (head.val < x){
//                sh==null说明小数链表还没添加过，就把头尾都设为head
                if (sh == null){
                    sh = head;
                    st = head;
//                    如果小数链表添加过，只需要把head赋给尾节点st的next指向，然后让st指向下一个节点
                }else{
                    st.next = head;
                    st = st.next;
                }
            }else {
                if (bh == null){
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = bt.next;
                }
            }
//            最后利用暂存的next节点更新head
            head = next;
        }
//        判断一下st是否为空防止空指针
        if (st != null)
            st.next = bh;
        return sh == null ? bh : sh;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode res = partition(head, 3);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
