package uniquePathsWithObstacles_63;

import org.junit.Test;

/**
 * @Description:
 * 暴力递归
 * @Author: chong
 * @Data: 2021/8/10 7:26 下午
 */
public class MySolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process(obstacleGrid, 0, 0);
    }

    public int process(int[][] ob, int row, int col){
        if (row == ob.length || col == ob[0].length){
            return 0;
        }
        if (ob[row][col] == 1){
            return 0;
        }
        if (row == ob.length - 1 && col == ob[0].length - 1){
            return 1;
        }

        return process(ob, row + 1, col) + process(ob, row, col + 1);
    }

    @Test
    public void test() {
        int[][] ob = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = uniquePathsWithObstacles(ob);
        System.out.println(res);
    }
}
