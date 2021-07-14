package isValidBST_98;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/27 2:13 下午
 */
public class MySolution {
    public boolean isValidBST(TreeNode root){
        if (root == null){
            return false;
        }
//        建立一个栈用于实现中序遍历
        LinkedList<TreeNode> stack = new LinkedList<>();
        int lastNum = Integer.MIN_VALUE;
        int count = 0;
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                if (count == 0 || lastNum < root.val) {
                    lastNum = root.val;
                    count++;
                }
                else
                    return false;
                root = root.right;
            }
        }
        return true;
    }
}
