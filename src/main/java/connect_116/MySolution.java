package connect_116;

import utils.NextNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * BFS
 * @Author: chong
 * @Data: 2021/8/15 5:46 下午
 */
public class MySolution {
    public NextNode connect(NextNode root) {
        if (root == null){
            return root;
        }

        Queue<NextNode> queue = new LinkedList<>();
        NextNode res = root;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            NextNode prevNode = new NextNode();
            for (int i = 0; i < size; i++){
                NextNode node = queue.poll();
                prevNode.next = node;
                prevNode = node;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
