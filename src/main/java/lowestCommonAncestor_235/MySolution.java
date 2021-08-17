package lowestCommonAncestor_235;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/15 11:45 下午
 */
public class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val)){
            return root;
        }
        if (root == p || root == q){
            return root;
        }

        TreeNode res = new TreeNode();

        if (p.val > root.val){
            res = lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val){
            res = lowestCommonAncestor(root.left, p, q);
        }

        return res;
    }
}
