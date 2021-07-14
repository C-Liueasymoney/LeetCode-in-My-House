package maxAreaOfIsland_695;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/8 3:36 下午
 */
public class MySolution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null)
            return 0;

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j, row, col), res);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j, int row, int col){
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1)
            return 0;

        grid[i][j] = 2;


        return dfs(grid, i + 1, j, row, col) + dfs(grid, i - 1, j, row, col)
                + dfs(grid, i, j + 1, row, col) + dfs(grid, i, j - 1, row, col) + 1;
    }

    @Test
    public void test(){
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int res = maxAreaOfIsland(grid);
        System.out.println(res);
    }
}
