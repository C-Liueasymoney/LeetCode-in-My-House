package addTwoNumbers_2;


import com.sun.corba.se.spi.ior.IdentifiableFactory;
import com.sun.xml.internal.messaging.saaj.soap.impl.DetailImpl;
import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/4 1:49 下午
 */
public class MySolution {
    public ListNode addTwoNumbersWay(ListNode l1, ListNode l2){
        // 进位项，有进位时decade为1，无进位时decade为0
        int decade = 0;
        // 设置一个预先指针，便于先初始化一个节点，并且能够保存输出结果链表的首项
        ListNode head = new ListNode(0);
        // 利用尾指针的不断后移为此链表增加元素
        ListNode tail = head;
        // l1和l2都为空才跳出循环，因为两个链表长度不一定相等
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                // 两个链表都还没遍历完时，相加结果就等于两个链表对应元素再加上上一位的进位
                int sum = l1.val + l2.val + decade;
                // sum%10就是只取sum的个数位，暂时不管进位问题
                tail.next = new ListNode(sum % 10);
                // 注意这里要先给tail.next赋值再对tail赋值，如果是这样：tail = new ListNode(sum % 10);
                // tail = tail.next；那么这里最后就会把null赋给tail，导致head的指向是：head -> tail -> null
                // 使得整个链表断掉。
                tail = tail.next;

                // 这里设置此轮的进位，如果sum>9进位为1，否则进位为0
                decade = sum / 10;

                l1 = l1.next;
                l2 = l2.next;
                // l1链表遍历完，l2还没的情况，就要继续把l2遍历完
            }else if (l1 == null){
                int sum = l2.val + decade;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                decade = sum / 10;
                l2 = l2.next;
            }else {
                int sum = l1.val + decade;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
                decade = sum / 10;
                l1 = l1.next;
            }
        }
        // 最后遍历完l1和l2还要判断一下最终有没有进位，如果有那还要再添加一项元素
        if (decade > 0){
            tail.next = new ListNode(decade);
        }
        // 返回预先指针的下一位就是求和链表真正的开始处
        return head.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l1.next = new ListNode(9);
        l2.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbersWay(l1, l2);

    }

}
