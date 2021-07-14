package convertBST_538;

import utils.TreeNode;

import java.util.logging.Level;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/5 4:12 下午
 */
public class MySolution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root){
        if (root == null)
            return root;
        dfs(root);
        return root;
    }

    // value用来向子节点传递遍历过的比其大的数之和
    public void dfs(TreeNode root){
        if (root == null)
            return;

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
