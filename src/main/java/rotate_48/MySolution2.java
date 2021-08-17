package rotate_48;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * 把矩阵按照对角线翻转，再按中心竖线翻转就得到旋转90度矩阵
 * @Author: chong
 * @Data: 2021/8/5 2:57 下午
 */
public class MySolution2 {
    public void rotate(int[][] matrix){
        int len = matrix.length;

        // 对角线翻转
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int[] indexA = {i, j};
                int[] indexB = {j, i};
                swap(matrix, indexA, indexB);
            }
        }

        for (int i = 0; i < len; i++){  // 行
            for (int j = 0; j < len / 2; j++){  // 列
                int[] indexA = {i, j};
                int[] indexB = {i, len - j - 1};
                swap(matrix, indexA, indexB);
            }
        }
    }

    private void swap(int[][] matrix, int[] indexA, int[] indexB){
        int temp = matrix[indexA[0]][indexA[1]];
        matrix[indexA[0]][indexA[1]] = matrix[indexB[0]][indexB[1]];
        matrix[indexB[0]][indexB[1]] = temp;
    }


    @Test
    public void test(){
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
//        int[][] matrix = {{1, 2}, {3, 4}};
        rotate(matrix);
        for (int[] m : matrix){
            System.out.println(Arrays.toString(m));
        }
    }
}
