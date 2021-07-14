package maxDepth_104;

import org.junit.Test;
import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/27 4:04 下午
 */
public class MySolution {
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
