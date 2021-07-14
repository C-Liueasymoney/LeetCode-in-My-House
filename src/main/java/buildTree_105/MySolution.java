package buildTree_105;

import org.junit.Test;
import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/2 1:22 下午
 */
public class MySolution {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length == 0)
            return null;

        return recur(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode recur(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if (inStart > inEnd)
            return null;
        TreeNode root;
        if (preStart < preorder.length) {
            root = new TreeNode(preorder[preStart]);
        }else
            return null;
        if (inStart == inEnd)
            return root;

        int index = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == preorder[preStart])
                index = i;
        }

        root.left = recur(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = recur(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);

        return root;
    }

    @Test
    public void test(){
        int[] preOrder = {1, 2};
        int[] inOrder = {1, 2};

        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println(root.left);
    }
}
