package wordBreak_139;

import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/7 4:14 下午
 */
public class MySolution {
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] visited = new boolean[s.length() + 1];
        return process(s, 0, visited, wordDict);
    }

    public boolean process(String s, int start, boolean[] visited, List<String> wordDict){
        for (String word : wordDict){
            int nextStart = start + word.length();
            if (nextStart > s.length() || visited[nextStart])
                continue;

            if (s.indexOf(word, start) == start){
                if (nextStart == s.length() || process(s, nextStart, visited, wordDict))
                    return true;
                visited[nextStart] = true;
            }
        }
        return false;
    }
}
