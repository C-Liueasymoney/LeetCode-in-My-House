package BSTIterator_173;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/27 4:35 下午
 */
public class MySolution {
    List<TreeNode> list = new ArrayList<>();
    int index = -1;
    public MySolution(TreeNode root){
        process(root);
    }

    public int next() {
        return list.get(++index).val;
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }

    public void process(TreeNode root){
        if (root == null)
            return;

        process(root.left);
        list.add(root);
        process(root.right);
    }
}
