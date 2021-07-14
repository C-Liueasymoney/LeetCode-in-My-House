package Codec_297;

import org.junit.Test;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/28 10:47 上午
 */
public class MySolution {

    // 使用先序遍历序列化，下划线_代表一个节点的结束，#代表null
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#_";
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++){
            queue.add(strs[i]);
        }
        return desByOrder(queue);
    }

    /**
     * 用于辅助反序列化，迭代返回反序列化结果的头节点
     * @param queue
     * @return
     */
    public TreeNode desByOrder(Queue<String> queue){
        // 每次从queue中取出一个值
        String value = queue.poll();
        // 如果取值为#说明该节点应该为null，直接返回
        if (value.equals("#")){
            return null;
        }
        // 当前root设置为取出值
        TreeNode root = new TreeNode(Integer.parseInt(value));
        // 左右节点进去递归
        root.left = desByOrder(queue);
        root.right = desByOrder(queue);
        return root;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        String serialize = serialize(root);
        System.out.println(serialize);

        TreeNode desRoot = deserialize(serialize);
        System.out.println(desRoot.val);
        System.out.println(desRoot.right.val);
        System.out.println(desRoot.right.left.val);
    }
}
