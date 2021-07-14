package isSymmetric_101;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/1 3:31 下午
 */
public class MySolution {

    public boolean isSymmetric(TreeNode root){
        if (root == null)
            return true;

        return process(root.left, root.right);
    }

    public boolean process(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null)
            return false;
        if (right == null)
            return false;

        if (left.val != right.val)
            return false;

        return process(left.left, right.right) && process(left.right, right.left);
    }



    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }
}
