package binaryTreePaths_257;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/25 3:40 下午
 */
public class MySolution {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        process(root, "");
        return res;
    }

    public void process(TreeNode root, String str){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){  // 提前在root为叶子节点的时候返回
            str += root.val;
            res.add(str);
            return;
        }

        str += root.val + "->";
        process(root.left, str);
        process(root.right, str);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }
}
