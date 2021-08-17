package permuteUnique_47;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/9 10:51 下午
 */
public class MySolution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
//        // 要想实现在递归中去重剪枝，则必须要让数组有序
//        Arrays.sort(nums);   // 这个方法用的set就不用有序了，可见优化后的方法
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

        Set<Integer> set = new HashSet<>();     // 用于去重

        for (int i = 0; i < nums.length; i++){
            if (!visited[i] && !set.contains(nums[i])){  // 该位置上元素没被拿才继续,并且去重
                visited[i] = true;
                list.add(nums[i]);
                process(nums, depth + 1, list, visited);
                list.remove(list.size() - 1);    // 回溯
                visited[i] = false;
                set.add(nums[i]);
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
