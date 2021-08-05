package recoverTree_99;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/25 5:00 下午
 */
public class MySolution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        process(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).val < list.get(i - 1).val){
                y = list.get(i);
                if (x == null)
                    x = list.get(i - 1);
            }
        }

        if (x != null && y != null){
            swap(x, y);
        }
    }

    public void process(TreeNode root, List<TreeNode> list){
        if (root == null)
            return;
        process(root.left, list);
        list.add(root);
        process(root.right, list);
    }

    public void swap(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
