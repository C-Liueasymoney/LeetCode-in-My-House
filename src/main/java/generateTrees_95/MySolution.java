package generateTrees_95;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/30 2:47 下午
 */
public class MySolution {
    public List<TreeNode> generateTrees(int n){
        if (n == 0)
            return null;
        return process(1, n);
    }

    public List<TreeNode> process(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        if (start == end){
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> leftTree = process(start, i - 1);
            List<TreeNode> rightTree = process(i + 1, end);

            for (TreeNode left : leftTree){
                for (TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        List<TreeNode> res = generateTrees(4);
        System.out.println(res.size());
    }
}
