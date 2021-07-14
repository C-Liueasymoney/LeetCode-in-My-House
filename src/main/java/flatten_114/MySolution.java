package flatten_114;

import utils.TreeNode;

/**
 * @Description:
 * 递归对树进行DFS后序遍历（要最后处理根），然后到最后把每个遍历到的根节点，left变成它的right，right变成left的right，原left设null
 * @Author: chong
 * @Data: 2021/7/2 2:08 下午
 */
public class MySolution {
    public void flatten(TreeNode root){
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        // 左子节点不为null的时候才有必要调整
        if (root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null){
                root = root.right;
            }
            root.right = temp;
        }
    }
}
