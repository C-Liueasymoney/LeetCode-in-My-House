package isValidBST_98;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import utils.TreeNode;

/**
 * @Description:
 * 利用搜索二叉树性质
 * @Author: chong
 * @Data: 2021/7/26 10:15 下午
 */
public class MySolution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        return process(root, null, null);
    }

    /**
     * 分别利用min、maxRoot来划定左右子树的分界线
     * 其实也就代表了一个左树节点和一个右树节点的父节点
     * @param root
     * @param minRoot 树中最小值
     * @param maxRoot 记录当前树中的最大值，也就是当前root的父节点(root是左子节点)
     * @return
     */
    public boolean process(TreeNode root, TreeNode minRoot, TreeNode maxRoot){
        if (root == null)
            return true;

        if (minRoot != null && root.val <= minRoot.val)
            return false;
        if (maxRoot != null && root.val >= maxRoot.val)
            return false;

        return process(root.left, minRoot, root) && process(root.right, root, maxRoot);
    }
}
