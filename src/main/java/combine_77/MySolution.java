package combine_77;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 11:31 下午
 */
public class MySolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        process(n, k, 1, 0, new ArrayList<>());
        return res;
    }

    public void process(int n, int k, int index, int depth, List<Integer> list){
        if (depth == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++){
            list.add(i);
            process(n, k, i + 1, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }


    @Test
    public void test(){
        List<List<Integer>> res = combine(4, 2);
        System.out.println(res);
    }
}
