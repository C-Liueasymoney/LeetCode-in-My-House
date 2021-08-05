package topKFrequent_347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description:
 * 优先队列
 * @Author: chong
 * @Data: 2021/7/21 11:11 下午
 */
public class MySolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (Integer key : map.keySet()){
            heap.add(key);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
