package deleteNode_450;

import utils.TreeNode;

import java.rmi.dgc.Lease;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/26 10:49 下午
 */
public class MySolution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        // 搜索过程
        if (root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }else{  // root.val == key
            if (root.right == null && root.left == null){ // 情况一：root是叶子节点
                return null;
            }else if (root.left == null){  // 情况二：root左子节点为null，说明右子节点不空，让右子节点接替自己
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {   // 情况三：此时root的左右子节点都不为空，为了不违反BST的规则，就要进行判断了
                // 这里需要找到root的左树中最大值或者右树中最小值来代替自己，这里定为找右树最小
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;    // 把最小值赋给root来接替root
                root.right = deleteNode(root.right, minNode.val);    // 继续调用此方法把最小node给删了
                return root;
            }
        }
    }

    public TreeNode findMin(TreeNode root){  // 一BST中找最小值就是找最左节点
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}
