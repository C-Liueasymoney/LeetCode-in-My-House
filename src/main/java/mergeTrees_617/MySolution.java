package mergeTrees_617;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/5 6:22 下午
 */
public class MySolution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return null;
        TreeNode root = null;
        root = merge(root, root1, root2);
        return root;
    }

    public TreeNode merge(TreeNode root, TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return null;

        int treeOne = root1 == null ? 0 : root1.val;
        int treeTwo = root2 == null ? 0 : root2.val;

        root = new TreeNode(treeOne + treeTwo);

        if (root1 != null && root2 != null){
            root.left = merge(root.left, root1.left, root2.left);
            root.right = merge(root.right, root1.right, root2.right);
        }else if (root1 == null){
            root.left = merge(root.left, null, root2.left);
            root.right = merge(root.right, null, root2.right);
        }else {
            root.left = merge(root.left, root1.left, null);
            root.right = merge(root.right, root1.right, null);
        }
        return root;
    }
}
