package isBalanced_110;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/27 4:42 下午
 */
public class MySolution2 {
    public boolean isBalanced(TreeNode root){
        return process(root) != -1;
    }

    // 本质上是利用后序遍历从底至上统计子树高度
    public int process(TreeNode root){
//        如果root到底了，返回高度0
        if (root == null)
            return 0;
//        去统计子树高度
        int leftHeight = process(root.left);
//        提前剪枝，高度等于-1代表高度差已经大于1了不是平衡树
        if (leftHeight == -1)
            return -1;
//        统计右树高度
        int rightHeight = process(root.right);
        if (rightHeight == -1)
            return -1;
//        返回当前节点的高度，或者如果当前已经不是平衡树了（左右子树高度差大于1）就返回-1直接表示不是平衡二叉树
        return Math.abs(leftHeight - rightHeight) < 2 ? Math.max(leftHeight, rightHeight) + 1: -1;
    }
}
