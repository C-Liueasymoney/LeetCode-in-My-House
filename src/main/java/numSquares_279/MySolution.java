package numSquares_279;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * BFS方法
 * @Author: chong
 * @Data: 2021/7/18 4:37 下午
 */
public class MySolution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++){
                int temp = queue.poll();
                for (int j = 1; j * j <= temp; j++){
                    int neg = temp - (j * j);
                    if (neg == 0)
                        return level;
                    queue.add(neg);
                }
            }
        }
        return -1;
    }


    @Test
    public void test(){
        int res = numSquares(13);
        System.out.println(res);
    }
}
