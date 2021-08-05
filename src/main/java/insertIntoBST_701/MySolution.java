package insertIntoBST_701;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/26 10:37 下午
 */
public class MySolution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }

        if (root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
