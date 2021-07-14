package invertTree_226;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/4 12:28 上午
 */
public class MySolution {
    public TreeNode invertTree(TreeNode root){
        if (root == null)
            return root;

        recur(root);
        return root;
    }

    public void recur(TreeNode root){
        if (root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        recur(root.left);
        recur(root.right);
    }
}
