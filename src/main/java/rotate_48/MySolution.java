package rotate_48;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/12 9:16 上午
 */
public class MySolution {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n / 2 ; i++){
            int[] leftUpper = {0 + i, 0 + i};
            int[] rightUpper = {0 + i, n - 1 - i};
            int[] leftDown = {n - 1 - i, 0 + i};
            int[] rightDown = {n - 1 - i, n -1 - i};
            while (leftUpper[0] < n - 1 - i) {
                swap(matrix, leftUpper, rightUpper);
                swap(matrix, leftUpper, leftDown);
                swap(matrix, leftDown, rightDown);
                leftUpper[0]++;
                rightUpper[1]--;
                leftDown[1]++;
                rightDown[0]--;
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
