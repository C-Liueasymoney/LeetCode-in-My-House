package rob_337;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * DFS:向上传递子树的信息
 * @Author: chong
 * @Data: 2021/7/4 10:13 上午
 */
public class MySolution {
    public int rob(TreeNode root){
        int[] res = recur(root);
        return Math.max(res[0], res[1]);
    }


    public int[] recur(TreeNode root){
        if (root == null)
            return new int[2];
        int[] result = new int[2];

        int[] left = recur(root.left);
        int[] right = recur(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }
}
