package sumNumbers_129;

import org.junit.Test;
import utils.TreeNode;

import java.awt.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/24 10:07 下午
 */
public class MySolution {
    public int sumNumbers(TreeNode root) {
        return process(root, 0);
    }

    public int process(TreeNode root, int prevSum){
        if (root == null)
            return 0;

        int sum = root.val + prevSum * 10;
        if (root.left == null && root.right == null)
            return sum;
        else
            return process(root.left, sum) + process(root.right, sum);
    }



    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int res = sumNumbers(root);
        System.out.println(res);
    }
}
