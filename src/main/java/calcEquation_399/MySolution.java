package calcEquation_399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/12 8:58 下午
 */
public class MySolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind(2 * equations.size());

        Map<String, Integer> map = new HashMap<>(2 * equations.size());
        int id = 0;

        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

        }
        return null;
    }

    static class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            parent[rootX] = rootY;
            weight[rootX] = weight[rootY] * value / weight[x];
        }


        public int find(int x){
            if (x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return weight[x] / weight[y];
            }else {
                return  -1.0d;
            }
        }
    }
}
