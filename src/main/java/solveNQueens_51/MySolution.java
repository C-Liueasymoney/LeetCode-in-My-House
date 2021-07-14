package solveNQueens_51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/4 2:53 下午
 */
public class MySolution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n){
        if (n < 1){
            return null;
        }
        result = new ArrayList<>();
        int[] record = new int[n];  // record[i] -> 第i行第皇后放在了第几列上（下标代表行，值代表第几列）
        process(0, record, n, new ArrayList<>());
        return result;
    }


    public void process(int i, int[] record, int n, List<String> strList){
        if (i == n) {
            result.add(new ArrayList<>(strList));
            return;
        }

        char[] chars = new char[n];
        Arrays.fill(chars, '.');

        // 判断当前在第i行的皇后，放在第j列会不会产生冲突,这里是要找出第i行上所有可以放置的方案
        for (int j = 0; j < n; j++){
            if (isVaild(record, i, j)){
                record[i] = j;     // 如果有效不冲突，可以在第i行第j列上放上皇后
                chars[j] = 'Q';
                strList.add(String.valueOf(chars));
                process(i + 1, record, n, strList);     // 继续开始下一行的放置
                strList.remove(strList.size() - 1);
                chars[j] = '.';
            }
        }
    }

    /**
     * 检查第i行第j列的皇后和0到i - 1的皇后是否冲突,只看i行之前的，因为当前在第i行放皇后
     * @param record
     * @param i
     * @param j
     * @return
     */
    public boolean isVaild(int[] record, int i, int j){
        for (int k = 0; k < i; k++){
            // 第j行是否和之前的某行上皇后放置的列相同了 || 是否列差等于行差（处于同斜线）
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
