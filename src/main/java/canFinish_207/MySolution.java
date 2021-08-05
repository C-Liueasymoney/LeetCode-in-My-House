package canFinish_207;

import org.junit.Test;

import javax.management.relation.RelationSupport;
import java.util.*;

/**
 * @Description:
 * 初始做法，自己构建图，转化，使用熟悉的拓扑排序算法。
 * @Author: chong
 * @Data: 2021/7/16 4:02 下午
 */
public class MySolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = transfer(prerequisites);

        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        for (Node n : graph.nodeMap.values()){
            // 统计每个节点的入度
            inMap.put(n, n.in);
            if (n.in == 0){    // 把入度为0的节点放入队列，准备处理（入度为0的节点都是不被其他节点所依赖的）
                nodeQueue.add(n);
            }
        }

        // 存放结果
        List<Node> result = new ArrayList<>();

        while (!nodeQueue.isEmpty()){
            Node cur = nodeQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);     // 拿掉cur节点，cur节点的邻居节点的入度都应该减1
                if (inMap.get(next) == 0)
                    nodeQueue.add(next);
            }
        }
        return result.size() == graph.nodeMap.size();    // 判断最后能够处理的课程数是否等于有安排的课程数即可
    }

    public Graph transfer(int[][] pre){
        Graph graph = new Graph();
        for (int i = 0; i < pre.length; i++){
            int from = pre[i][0];
            int to = pre[i][1];
            if (!graph.nodeMap.containsKey(from)){
                graph.nodeMap.put(from, new Node(from));
            }
            if (!graph.nodeMap.containsKey(to)){
                graph.nodeMap.put(to, new Node(to));
            }

            Node fromNode = graph.nodeMap.get(from);
            Node toNode = graph.nodeMap.get(to);

            Edge edge = new Edge(0, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edgeSet.add(edge);
        }
        return graph;
    }


    @Test
    public void test(){
        int[][] pre = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean res = canFinish(5, pre);
        System.out.println(res);
    }
}



class Node{
    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}

class Edge{
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}

class Graph{
    public Map<Integer, Node> nodeMap;
    public Set<Edge> edgeSet;

    public Graph() {
        nodeMap = new HashMap<>();
        edgeSet = new HashSet<>();
    }

}