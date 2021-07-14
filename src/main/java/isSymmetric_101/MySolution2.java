package isSymmetric_101;

import com.sun.tools.javac.util.RichDiagnosticFormatter;
import org.junit.Test;
import utils.TreeNode;

import java.util.LinkedList;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/1 4:01 下午
 */
public class MySolution2 {
    public boolean isSymmetric(TreeNode root){
        if (root == null || (root.right == null && root.left == null))
            return true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
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
