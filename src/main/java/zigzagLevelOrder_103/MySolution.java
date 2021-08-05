package zigzagLevelOrder_103;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/24 2:34 下午
 */
public class MySolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tempList = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    tempList.addFirst(node.val);
                } else {
                    tempList.add(node.val);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(new ArrayList<>(tempList));
            level++;
        }
        return res;
    }
}
