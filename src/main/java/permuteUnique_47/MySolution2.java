package permuteUnique_47;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * 优化了一下
 * @Author: chong
 * @Data: 2021/8/9 11:21 下午
 */
public class MySolution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 要想实现在递归中去重剪枝，则必须要让数组有序
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        process(nums, 0, new ArrayList<>(), visited);
        return res;
    }

    /**
     *
     * @param nums
     * @param depth 代表递归的深度，也就是此时从nums中选择了多少个元素，当depth=nums.length说明nums元素已经被拿完了
     * @param list
     * @param visited 用来记录nums中哪些元素被拿走了
     */
    public void process(int[] nums, int depth, List<Integer> list, boolean[] visited){
        if (depth == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < nums.length; i++){
            // 注意这里判断的最后 visited[i]，就是说要保证当前元素与之前元素不同，是在之前一个元素没有被使用过的情况下
            // 如果是被使用过，那在此轮迭代中并不影响，因此也可以继续
            if (!visited[i] && (i == 0 || nums[i] != nums[i -1] || visited[i - 1])){  // 该位置上元素没被拿才继续,并且去重
                visited[i] = true;
                list.add(nums[i]);
                process(nums, depth + 1, list, visited);
                list.remove(list.size() - 1);    // 回溯
                visited[i] = false;
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
}
