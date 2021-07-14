package exist_79;


import com.sun.corba.se.impl.transport.ReadTCPTimeoutsImpl;
import com.sun.corba.se.spi.ior.iiop.IIOPFactories;
import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/21 3:39 下午
 */
public class MySolution {
    public boolean exist(char[][] board, String word){
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                flag |= recur(board, visited, word, 0, i, j);
            }
        }
        return flag;
    }

    private boolean recur(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        char letter = word.charAt(index);
//        如果当前字母已经是word中最后一位，且和board中对应方格相等，返回true
        if (index == word.length() - 1 && letter == board[row][col])
            return true;

//        如果当前字母和当前board中对应方格不等直接返回false
        if (letter != board[row][col])
            return false;
        visited[row][col] = true;
        boolean flag = false;

//        如果当前字母和board对应方格相等，但不是word中最后一位，需要继续递归。用visited数组记录已经访问过的方格
        if (row + 1 < board.length && !visited[row + 1][col])
            flag |= recur(board, visited, word, index + 1, row + 1, col);
        if (row - 1 >= 0 && !visited[row - 1][col])
            flag |= recur(board, visited, word, index + 1, row - 1, col);
        if (col + 1 < board[0].length && !visited[row][col + 1])
            flag |= recur(board, visited, word, index + 1, row, col + 1);
        if (col - 1 >= 0 && !visited[row][col - 1])
            flag |= recur(board, visited, word, index + 1, row, col - 1);
//        最后返回前别忘了把visited访问回溯掉
        visited[row][col] = false;
        return flag;
    }

    @Test
    public void test(){
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'a'}};
        boolean res = exist(board, "ABCCED");
        System.out.println(res);
    }
}
