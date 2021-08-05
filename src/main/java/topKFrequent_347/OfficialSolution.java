package topKFrequent_347;

import java.util.*;

/**
 * @Description:
 * 桶排序思想
 * @Author: chong
 * @Data: 2021/7/22 10:04 下午
 */
public class OfficialSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if (bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i > bucket.length - k; i--){
        }
        return null;
    }
}
