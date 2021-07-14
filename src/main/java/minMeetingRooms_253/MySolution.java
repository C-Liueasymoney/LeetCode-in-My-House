package minMeetingRooms_253;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/10 11:04 下午
 */
public class MySolution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals[0] == null)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals){
            if (heap.isEmpty()){
                heap.add(interval[1]);
            }else {
                if (interval[0] >= heap.peek()){
                    heap.poll();
                    heap.add(interval[1]);
                }else {
                    heap.add(interval[1]);
                }
            }
        }

        return heap.size();
    }

    @Test
    public void test(){
        int[][] intervals = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        int res = minMeetingRooms(intervals);
        System.out.println(res);
    }
}
