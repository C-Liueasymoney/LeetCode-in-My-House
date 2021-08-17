package minDepth_111;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/15 5:27 下午
 */
public class MySolution {
    int res;
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        res = Integer.MAX_VALUE;
        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if (root.left == null && root.right == null){
            res = Math.min(res, depth);
            return;
        }

        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
