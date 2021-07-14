package isBalanced_110;

import org.junit.Test;
import utils.TreeNode;

import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/27 4:21 下午
 */
public class MySolution {
    public boolean isBalanced(TreeNode root){
        return process(root).isBalanced;
    }

    // 递归函数
    public ReturnType process(TreeNode x){
        if (x == null)
            return new ReturnType(true, 0);

//        拿到左右树返回的信息
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

//        拿到左右子树中最大的高度+1作为x的高度
        int height = Math.max(leftData.height, rightData.height) + 1;
//        x平衡的条件：左右子树平衡，左右子树高度差最大是1
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced, height);
    }

//    由于左右子树需要向上传递两个值，所以把这两个值封装在内部类中
    public static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);
        boolean res = isBalanced(root);
        System.out.println(res);
    }
}


