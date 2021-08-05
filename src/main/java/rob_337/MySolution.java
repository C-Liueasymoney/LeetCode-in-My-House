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
        // 这里的int数组只包含两位，一个代表该节点抢劫的情况，一个代表该节点不抢劫的情况，相当于把Info类简化成数组形式
        int[] res = recur(root);
        return Math.max(res[0], res[1]);
    }


    public int[] recur(TreeNode root){
        if (root == null)
            return new int[2];
        int[] result = new int[2];

        // 分别获得左右节点的抢与不抢的情况值
        int[] left = recur(root.left);
        int[] right = recur(root.right);

        // 0位置表示当前节点不抢，1位置表示当前节点抢
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);     // 情况1：root节点不打劫，结果：0 + 左右节点要么选择打劫要么选择不打劫情况下的最大值
        result[1] = root.val + left[0] + right[0];                  // 情况2：root节点打劫，结果等于：根节点值 + 左右节点不打劫情况下返回值

        return result;
    }
}
