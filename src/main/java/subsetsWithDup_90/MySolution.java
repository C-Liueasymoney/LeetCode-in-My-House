package subsetsWithDup_90;

import org.junit.Test;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/10 7:00 下午
 */
public class MySolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        process(nums, 0, new ArrayList<>());
        return res;
    }

    public void process(int[] nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            if (i == index || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                process(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
    }
}
