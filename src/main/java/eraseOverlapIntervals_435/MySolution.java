package eraseOverlapIntervals_435;

import java.util.Arrays;
import java.util.stream.StreamSupport;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/11 5:00 下午
 */
public class MySolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals[0] == null)
            return -1;

        int res = 0;
        int startPoint = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for (int[] interval : intervals){
            if (startPoint <= interval[0]){
                res++;
                startPoint = interval[1];
            }
        }
        return intervals.length - res;
    }
}
