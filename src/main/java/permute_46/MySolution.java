package permute_46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/11 2:37 下午
 */
public class MySolution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);
        recur(numsList, new ArrayList<>());
        return result;
    }

    public void recur(List<Integer> nums, List<Integer> temp){
        if (nums.size() <= 0) {
//            依旧是Java的按值传递问题
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.size(); i++){
//            注意这里选择的方案是将nums用List保存以方便去除掉已经选择过的节点
//            但这种方法即新创建了一个数组空间，又导致在add插入回节点的过程中有O（N）的时间开销
//            解决办法可以设置一个boolean数组，以false或true来代表此节点有没有被选择过
            int num = nums.remove(i);
            temp.add(num);
            recur(nums, temp);
            temp.remove(temp.size() - 1);
            nums.add(i, num);
        }
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}
