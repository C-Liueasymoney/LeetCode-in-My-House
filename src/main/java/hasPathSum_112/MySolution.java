package hasPathSum_112;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/25 4:22 下午
 */
public class MySolution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return process(root, targetSum);
    }

    public boolean process(TreeNode root, int targetSum){
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return targetSum == root.val;


        return process(root.left, targetSum - root.val) ||
                process(root.right, targetSum - root.val);
    }
}
