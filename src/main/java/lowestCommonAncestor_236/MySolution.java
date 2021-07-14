package lowestCommonAncestor_236;

import org.junit.Test;
import utils.TreeNode;


/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/28 8:59 上午
 */
public class MySolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 在这里遇到其中一个直接返回
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);

        // 找到最近祖先
        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }




    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        TreeNode res = lowestCommonAncestor(root, root, root.right.left);
        System.out.println(res.val);
    }
}

class ReturnType{
    boolean p;
    boolean q;
    TreeNode parent;

    public ReturnType(boolean p, boolean q, TreeNode parent) {
        this.p = p;
        this.q = q;
        this.parent = parent;
    }
}
