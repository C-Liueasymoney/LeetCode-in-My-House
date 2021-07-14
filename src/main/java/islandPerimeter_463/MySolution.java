package islandPerimeter_463;

import oracle.jvm.hotspot.jfr.GlobalTraceBuffer;
import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/8 3:09 下午
 */
public class MySolution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0] == null)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1) {
                    res = dfs(grid, i, j, row, col);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int row, int col){
        if (i < 0 || i >= row || j < 0 || j >= col)
            return 1;
        if (grid[i][j] == 0)
            return 1;
        if (grid[i][j] == 2)
            return 0;

        grid[i][j] = 2;

        return dfs(grid, i + 1, j, row, col) + dfs(grid, i - 1, j, row, col)
                + dfs(grid, i, j + 1, row, col) + dfs(grid, i, j - 1, row, col);
    }

    @Test
    public void test(){
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int res = islandPerimeter(grid);
        System.out.println(res);
    }
}
