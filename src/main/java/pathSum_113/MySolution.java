package pathSum_113;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/25 4:46 下午
 */
public class MySolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root, targetSum, new ArrayList<>());
        return res;
    }

    public void process(TreeNode root, int targetSum, List<Integer> list){
        if (root == null)
            return;

        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }

        process(root.left, targetSum - root.val, list);
        process(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
}
