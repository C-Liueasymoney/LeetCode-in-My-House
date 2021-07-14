package leastInterval_621;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/6 5:44 下午
 */
public class MySolution {
    public int leastInterval(char[] tasks, int n){
        Map<Character, Integer> map = new HashMap<>();

        for (char t : tasks){
            if (map.containsKey(t))
                map.put(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }

        int maxTask = 0;
        int maxTaskNum = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() > maxTask) {
                maxTask = entry.getValue();
                maxTaskNum = 1;
            }else if (entry.getValue() == maxTask){
                maxTaskNum++;
            }
        }

        return Math.max((maxTask - 1) * (n + 1) + maxTaskNum, tasks.length);
    }

    @Test
    public void test(){
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int res = leastInterval(tasks, 2);
        System.out.println(res);
    }
}
