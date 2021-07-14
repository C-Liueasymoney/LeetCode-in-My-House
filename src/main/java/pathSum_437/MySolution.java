package pathSum_437;

import utils.TreeNode;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 前缀和
 * @Author: chong
 * @Data: 2021/7/5 3:02 下午
 */
public class MySolution {
    public int pathSum(TreeNode root, int targetSum){
        // key存放前缀和是几，value存放前缀和为key的有几个
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // 加一个前缀和为0的，代表当前节点,也就是从根节点到根节点的前缀和
        prefixSumMap.put(0, 1);
        return process(root, prefixSumMap, targetSum, 0);
    }

    // cur代表从根节点走到当前节点的前缀和
    public int process(TreeNode root, Map<Integer, Integer> prefixSumMap, int targetSum, int cur){
        // case base
        if (root == null)
            return 0;
        // res代表当前节点上能够找到的满足targetSum的路径数目
        int res = 0;
        // 当前路径和先加上当前节点的值，表示走到了此节点
        cur += root.val;
        // 由于两节点的前缀和之差等于两节点的路径和，那么要找到路径和等于targetSum的路径
        // 就是要找当前节点的前缀和减去targetSum有没有存在map中，就表示之前有没有出现过路径和为cur-targetSum的节点
        res += prefixSumMap.getOrDefault(cur - targetSum, 0);
        // 把当前节点的路径和保存在map中
        prefixSumMap.put(cur, prefixSumMap.getOrDefault(cur, 0) + 1);

        // 对左右节点的结果进行收集
        res += process(root.left, prefixSumMap, targetSum, cur);
        res += process(root.right, prefixSumMap, targetSum, cur);

        // 回溯要对map中保存的当前节点前缀和进行消除
        prefixSumMap.put(cur, prefixSumMap.get(cur) - 1);

        return res;
    }
}
