package combinationSum2_40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 8:26 下午
 */
public class MySolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        process(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void process(int[] can, int index, int target, List<Integer> list){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == can.length || target < 0){
            return;
        }

        for (int i = index; i < can.length; i++){
            if (i == index || can[i] != can[i - 1]){
                list.add(can[i]);
                process(can, i + 1, target - can[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test(){
        int[] can = {2, 5, 2, 1, 2};
        List<List<Integer>> res = combinationSum2(can, 5);
        System.out.println(res);
    }
}
