package generateMatrix_59;

import com.sun.corba.se.spi.ior.IORTemplateList;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/5 2:38 下午
 */
public class MySolution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        int temp = 1;

        while (a <= c && b <= d){
            temp = process(matrix, a++, b++, c--, d--, temp);
        }
        return matrix;
    }

    public int process(int[][] matrix, int a, int b, int c, int d, int n){
        if (a == c){
            for (int i = b; i <= d; i++){
                matrix[a][i] = n;
                n++;
            }
        }else if (b == d){
            for (int i = a; i <= c; i++){
                matrix[i][b] = n;
                n++;
            }
        }else {
            int curRow = a;
            int curCol = b;

            while (curCol != d){   // 第一步从左向右
                matrix[a][curCol] = n;
                n++;
                curCol++;
            }

            while (curRow != c){  // 第二步从上向下
                matrix[curRow][d] = n;
                n++;
                curRow++;
            }

            while (curCol != b){  // 第三步从右向左
                matrix[c][curCol] = n;
                n++;
                curCol--;
            }

            while (curRow != a){   // 第四步从下往上
                matrix[curRow][b] = n;
                n++;
                curRow--;
            }
        }
        return n;
    }

    @Test
    public void test(){
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.toString(res[1]));
    }
}
