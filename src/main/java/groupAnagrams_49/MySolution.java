package groupAnagrams_49;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/12 10:39 上午
 */
public class MySolution {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String str : strs){
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++){
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder word = new StringBuilder();
            for (int i = 0; i < counts.length; i++){
                if (counts[i] != 0){
                    word.append((char) ('a' + i));
                    word.append(counts[i]);
                }
            }
            String key = word.toString();
            List<String> wordList = wordMap.getOrDefault(key, new ArrayList<>());
            wordList.add(str);
            wordMap.put(key, wordList);
        }
        return new ArrayList<List<String>>(wordMap.values());
    }

    @Test
    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
}
