package levelOrder_102;

import org.junit.Test;
import utils.TreeNode;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/28 5:33 下午
 */
public class MySolution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        // 利用一个map保存节点与所处层数的映射
        Map<TreeNode, Integer> map = new HashMap<>();
        // 设置一个常量表示当前遍历的节点所处层数
        int curLevel = 1;
        // 先把root与对应的层数放入map
        map.put(root, 1);
        // queue来进行BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // temp作为临时列表保存当前层的所有节点
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if (map.get(cur) == curLevel){   // 如果当前节点cur属于记录的当前层curLevel，说明还没有跨层，在temp存入节点值
                temp.add(cur.val);
            }else {  // 当前节点已经不属于记录的当前层curLevel，说明在这个节点处跨层了，新开一个temp用于存入当前层的值，把老temp存入结果
                res.add(temp);
                temp = new ArrayList<>();
                temp.add(cur.val);
                curLevel++;    // 注意既然跨层了，就要把记录的当前层加一
            }

            if (cur.left != null){
                queue.add(cur.left);
                // 在左子节点不为空的情况下，除了要把左子节点放入queue，还要在map中记录左子节点对应的层，就是当前层+1
                map.put(cur.left, curLevel + 1);
            }
            if (cur.right != null){
                queue.add(cur.right);
                map.put(cur.right, curLevel + 1);
            }
        }
        // 这里最后要把最后一层的temp记录加入进去，因为在循环中每次跨层在res中保存的都是上一层的temp，最后一层的temp在循环中没有保存
        res.add(temp);
        return res;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);
    }
}
