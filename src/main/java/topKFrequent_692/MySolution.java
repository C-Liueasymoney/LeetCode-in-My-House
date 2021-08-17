package topKFrequent_692;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/6 3:36 下午
 */
public class MySolution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a) != 0 ? map.get(b) - map.get(a) : a.compareTo(b));

        for (String key : map.keySet()){
            heap.add(key);
        }

        for (int i = 0; i < k; i++){
            res.add(heap.poll());
        }

        return res;
    }


    @Test
    public void test(){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding", "u", "u"};
        List<String> res = topKFrequent(words, 3);
        System.out.println(res);
    }
}
