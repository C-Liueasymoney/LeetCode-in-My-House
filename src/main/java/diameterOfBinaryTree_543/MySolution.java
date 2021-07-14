package diameterOfBinaryTree_543;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/5 5:57 下午
 */
public class MySolution {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        if (root == null)
            return 0;
        process(root);
        return max;
    }

    public int process(TreeNode root){
        if (root == null)
            return 0;

        int left = process(root.left);
        int right = process(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
