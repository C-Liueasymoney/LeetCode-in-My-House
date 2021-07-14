package isPalindrome_234;

import org.junit.Test;
import utils.ListNode;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/24 4:23 下午
 */
public class MySolution {
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null)
            return true;
//        len保存链表长度O(N)
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
//        设置len为链表长度的一半
        len = len / 2;
//        设置快慢指针
        ListNode last = head;
        ListNode pre = head;
//        快指针先走到链表的一半处O(1/2N)
        for (int i = 0; i < len; i++){
            pre = pre.next;
        }
//        准备辅助节点来将快指针后面的一半链表反转
        ListNode reverLast = null;
        while (pre != null){
//            辅助节点先保存下快指针下一位
            ListNode reverTemp = pre.next;
//            把快指针前一位节点赋给快指针的下一位
            pre.next = reverLast;
//            把快指针当前位置赋给前一位的指针
            reverLast = pre;
//            把之前保存好的快指针下一位赋给快指针
            pre = reverTemp;
        }
//        从反转后的后半链表的头开始遍历，和前一半链表相比，有不相等直接false
        while (reverLast != null){
            if (reverLast.val != last.val)
                return false;
            reverLast = reverLast.next;
            last = last.next;
        }
        return true;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean res = isPalindrome(head);
        System.out.println(res);
    }
}
