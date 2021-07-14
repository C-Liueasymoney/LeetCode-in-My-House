package reconstructQueue_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/6 3:23 下午
 */
public class MySolution {
    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] p : people){
            if (p[1] >= res.size()){
                res.add(p);
            }else {
                res.add(p[1], p);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
