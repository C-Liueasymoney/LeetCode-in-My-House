package merge_56;

import com.sun.org.apache.xpath.internal.FoundIndex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/16 2:24 下午
 */
public class MySolution {
    public int[][] merge(int[][] intervals){
//        按照左端点对数组进行排序，也可以在左端点相等的时候再对右端点进行排序，但由于后面取的是右端点的最大值，所以没什么必要
//        Arrays.sort(intervals, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
//            如果i的右端点比i+1的左端点大或相等，那这两个就可以合并了
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0])
//                合并之后的左区间肯定是等于i的左区间，但右区间要看i和i+1的右区间哪个更大
                intervals[i + 1] = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])};
            else
                result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }


    @Test
    public void test(){
        int[][] intervals = {{1, 3}, {8, 10}, {15, 18}, {2, 6}, {1, 2}};
//        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] res = merge(intervals);
        for (int[] r : res){
            System.out.println(Arrays.toString(r));
        }

    }
}
