package canFinish_207;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * 入度表法
 * @Author: chong
 * @Data: 2021/7/16 5:20 下午
 */
public class OfficialSolution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表，记录所有节点的入度信息
        int[] inDegrees = new int[numCourses];
        // 邻接表表示图
        List<List<Integer>> adjacency = new ArrayList<>();
        // 队列保存入度为0的节点
        Queue<Integer> zeroQueue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());    // 初始化邻接表
        }
        for (int[] pre : prerequisites){
            inDegrees[pre[1]]++;    // 更新入度，此处是[i, j] i指向j，j节点的入度++，反过来j指向i也可以
            adjacency.get(pre[0]).add(pre[1]);    // 同时更新邻接表，i指向j，i的邻接表项加入j
        }

        for (int i = 0; i < inDegrees.length; i++){
            if (inDegrees[i] == 0)
                zeroQueue.add(i);     // 下标代表课程编号，这里把课程编号对应入度为0的课程编号加入queue
        }

        while (!zeroQueue.isEmpty()){
            int cur = zeroQueue.poll();
            numCourses--;      // 表示有一个课程安排完毕
            for (int next : adjacency.get(cur)){    // 对cur的邻居next消除cur的影响
                inDegrees[next]--;
                if (inDegrees[next] == 0)
                    zeroQueue.add(next);
            }
        }
        // 注意在这中情况下，如果prere没有安排某节课，那这节课的入度自动为0，numCourses一样会--
        return numCourses == 0;    // 是否所有课程都安排完毕
    }

    @Test
    public void test(){
        int[][] pre = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean res = canFinish(5, pre);
        System.out.println(res);
    }
}
