package buildTree_106;

import org.junit.Test;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/24 9:27 下午
 */
public class MySolution {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return process(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode process(int[] postorder, int ps, int pe, int is, int ie){
        if (ps > pe || is > ie)
            return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int index = map.get(postorder[pe]);

        root.left = process(postorder, ps, ps + index - is - 1, is, index - 1);
        root.right = process(postorder, ps + index - is, pe - 1, index + 1, ie);

        return root;
    }

    @Test
    public void test(){
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode node = buildTree(inorder, postorder);

    }
}
