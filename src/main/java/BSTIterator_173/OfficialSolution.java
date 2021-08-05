package BSTIterator_173;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * 相当于把中序遍历迭代版本拆到两个方法里去了
 * @Author: chong
 * @Data: 2021/7/27 4:48 下午
 */
public class OfficialSolution {
    Deque<TreeNode> stack = new LinkedList<>();

    public OfficialSolution(TreeNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode nextNode = stack.pop();
        TreeNode right = nextNode.right;
        while (right != null){
            stack.push(right);
            right = right.left;
        }
        return nextNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
