package canJump_55;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * BFS原理
 * @Author: chong
 * @Data: 2021/6/16 9:05 上午
 */
public class OfficialSolution {
    public boolean canJump(int[] nums){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
//        从下标0处开始
        queue.offer(0);
//        队列保存的是能到达的数组下标
        while (!queue.isEmpty()){
            int index = queue.poll();
//            数组下标大于等于数组长度-1返回true
            if (index >= nums.length - 1)
                return true;
//            把当前位置上能到达的所有数组下标全部加入队列中
            for (int i = index + 1; i < nums.length && i <= index + nums[index]; i++){
//                要检查当前下标是否被访问过了，防止额外的时间开销
                if (!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {1, 1, 1, 0};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
