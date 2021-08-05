package rightSideView_199;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/24 2:36 下午
 */
public class MySolution {
    List<Integer> res;
    int maxHeight = 0;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList();
        if (root == null)
            return res;

        process(root, 0);
        return res;
    }

    public void process(TreeNode root, int curHeight){
        if (root == null)
            return;

        curHeight++;
        if (curHeight > maxHeight){
            res.add(root.val);
            maxHeight = curHeight;
        }

        process(root.right, curHeight);
        process(root.left, curHeight);
    }
}
