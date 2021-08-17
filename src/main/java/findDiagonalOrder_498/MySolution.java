package findDiagonalOrder_498;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 从大局观上来看
 * @Author: chong
 * @Data: 2021/8/14 4:31 下午
 */
public class MySolution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0){
            return null;
        }
        int N = mat.length;
        int M = mat[0].length;

        // 定义两个对角点
        int[] pointA = {0, 0};
        int[] pointB = {0, 0};
        int[] res = new int[N * M];
        int index = 0;
        // 设定标志位表示应该从A点到B点遍历还是相反的顺序, true代表B->A
        boolean flag = true;

        // A点是先右移再下移，所以当A点下移到最低的时候就结束了；另外不用担心B点越界，因为两个点走过的路程长度是相等的
        while (pointA[0] < N){
            int i = 0;
            int j = 0;
            if (flag){
                i = pointB[0];
                j = pointB[1];
                while (i >= 0 && j < M){
                    res[index++] = mat[i][j];
                    i--;
                    j++;
                }
            }else {
                i = pointA[0];
                j = pointA[1];
                while (i < N && j >= 0){
                    res[index++] = mat[i][j];
                    i++;
                    j--;
                }
            }

            if (pointA[1] < M - 1){   // A点先左移到边缘再下移
                pointA[1]++;
            }else {
                pointA[0]++;
            }

            if (pointB[0] < N - 1){   // B点先下移再右移
                pointB[0]++;
            }else {
                pointB[1]++;
            }
            // 每次遍历一遍之后对flag取反
            flag = !flag;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = findDiagonalOrder(mat);
        System.out.println(Arrays.toString(res));
    }
}
