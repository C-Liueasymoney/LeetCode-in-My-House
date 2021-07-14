package combinationSum_39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/10 5:44 下午
 */
public class MySolution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
//        Arrays.sort(candidates);
        ArrayList<Integer> temp = new ArrayList<>();
        recur(candidates, target, 0, temp);
        return result;
    }

    public void recur(int[] candidates, int target, int left, List<Integer> temp){
        if (left >= candidates.length || target < 0)
            return;
        if (target == 0){
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }
        for (int i = left; i < candidates.length; i++){
            temp.add(candidates[i]);
            recur(candidates, target - candidates[i], i, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] candidates = {5,2,3};
        List<List<Integer>> res = combinationSum(candidates, 8);
        System.out.println(res);

    }
}
