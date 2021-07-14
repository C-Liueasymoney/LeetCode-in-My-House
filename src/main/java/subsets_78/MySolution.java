package subsets_78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/20 9:10 上午
 */
public class MySolution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums){
        result = new ArrayList<>();
        recur(nums, 0, new ArrayList<>());
        return result;
    }

    private void recur(int[] nums, int index, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            recur(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
