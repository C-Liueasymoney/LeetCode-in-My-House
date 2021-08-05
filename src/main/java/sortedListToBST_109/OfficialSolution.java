package sortedListToBST_109;

import com.sun.webkit.dom.WheelEventImpl;
import utils.ListNode;
import utils.TreeNode;

import java.util.List;

/**
 * @Description:
 * 利用中序遍历重构二叉搜索树
 * 这个重构的过程和遍历一样，都是先找到最左节点，然后再向上返回
 * @Author: chong
 * @Data: 2021/7/27 6:00 下午
 */
public class OfficialSolution {
    ListNode index;  // 用来指向当前遍历的链表节点
    public TreeNode sortedListToBST(ListNode head) {
        index = head;
        return process(0, length(head) - 1);
    }

    public TreeNode process(int left, int right){
        if (left > right)
            return null;

        int mid = left + ((right - left) >> 1);

        TreeNode leftNode = process(left, mid - 1);
        TreeNode root = new TreeNode(index.val);    // 利用成员变量，指向链表中的节点
        index = index.next;
        root.left = leftNode;
        root.right = process(mid + 1, right);   // 这个递归顺序和中序遍历一样
        return root;
    }

    public int length(ListNode head){
        int n = 0;
        while (head != null){
            head = head.next;
            n++;
        }
        return n;
    }
}
