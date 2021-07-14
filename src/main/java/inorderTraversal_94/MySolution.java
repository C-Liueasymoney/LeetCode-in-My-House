package inorderTraversal_94;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/21 4:29 下午
 */
public class MySolution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        if (root == null)
            return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        do {
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }while (!stack.isEmpty() || root != null);
        return res;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }
}
