package searchMatrix_74;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/6 3:05 下午
 */
public class MySolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0){
            if (target == matrix[i][j]){
                return true;
            }else if (matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }

        return false;
    }
}
