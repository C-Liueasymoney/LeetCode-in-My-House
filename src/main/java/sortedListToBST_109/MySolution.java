package sortedListToBST_109;

import utils.ListNode;
import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/27 5:28 下午
 */
public class MySolution {
    public TreeNode sortedListToBST(ListNode head) {
        return process(head, null);
    }

    public TreeNode process(ListNode left, ListNode right){
        if (left == right){
            return null;
        }

        ListNode fast = left;
        ListNode slow = left;
        while (fast.next != right && fast.next.next != right){  // 找到链表中点slow
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = process(left, slow);
        root.right = process(slow.next, right);

        return root;
    }
}
