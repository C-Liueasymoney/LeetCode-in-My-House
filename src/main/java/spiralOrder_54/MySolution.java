package spiralOrder_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/5 1:56 下午
 */
public class MySolution {
    // 由于矩阵不止可能是正方形，所以在两个对角线收缩的时候，可能会出现最后在同一行或同一列的情况
    // 把这两种情况单独拿出来分析即可，其他情况就是按照顺时针打印
    public List<Integer> spiralOrder(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (a <= c && b <= d){
            printEdge(matrix, a++, b++, c--, d--, res);
        }

        return res;
    }

    // abcd分别是两个对角点的横纵坐标
    public void printEdge(int[][] matrix, int a, int b, int c, int d, List<Integer> res){
        // 此时两个对角点在同一行上，从左向右打印
        if (a == c){
            for (int i = b; i <= d; i++){
                res.add(matrix[a][i]);
            }
        }else if (b == d){  // 对角点在同一列上，从上到下打印
            for (int i = a; i <= c; i++){
                res.add(matrix[i][b]);
            }
        }else {   // 此时对角点分布在对角线上
            int curRow = a;
            int curCol = b;

            while (curCol != d){   // 第一步从左向右
                res.add(matrix[a][curCol]);
                curCol++;
            }

            while (curRow != c){  // 第二步从上向下
                res.add(matrix[curRow][d]);
                curRow++;
            }

            while (curCol != b){  // 第三步从右向左
                res.add(matrix[c][curCol]);
                curCol--;
            }

            while (curRow != a){   // 第四步从下往上
                res.add(matrix[curRow][b]);
                curRow--;
            }
        }
    }
}
