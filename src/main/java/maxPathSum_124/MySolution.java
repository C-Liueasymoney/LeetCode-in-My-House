package maxPathSum_124;

import utils.TreeNode;

import javax.swing.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/3 10:33 下午
 */
public class MySolution {
    private int maxValue;
    public int maxPathSum(TreeNode root){
        maxValue = Integer.MIN_VALUE;
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root){
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        maxValue = Math.max(maxValue, root.val + left + right);

        int value = root.val + Math.max(left, right);

        return Math.max(value, 0);


//        if (Math.max(left, right) <= 0){
//            maxValue = Math.max(maxValue, root.val);
//            return root.val;
//        }else {
//            if (left < 0)
//                maxValue = Math.max(maxValue, root.val + right);
//            else if (right < 0)
//                maxValue = Math.max(maxValue, root.val + left);
//            else
//                maxValue = Math.max(maxValue, root.val + left + right);
//            return root.val + Math.max(left, right);
//        }
    }
}
