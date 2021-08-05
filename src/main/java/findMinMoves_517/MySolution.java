package findMinMoves_517;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/4 3:22 下午
 */
public class MySolution {
    public int findMinMoves(int[] machines) {
        int size = machines.length;
        int sum = 0;
        for (int i = 0; i < size; i++){  // 统计衣服总数
            sum += machines[i];
        }
        if (sum % size != 0) {   // 排除不满足条件
            return -1;
        }

        int avg = sum / size;
        // 左侧遍历过部分的累加和（实际数量）
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < machines.length; i++){
            // 如果是负数代表需要输入的衣服数量， 正数代表需要输出
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - machines[i]) - (size - i - 1) * avg;

            if (leftRest < 0 && rightRest < 0){
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            }else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {0,0,0,4};
        int minMoves = findMinMoves(nums);
        System.out.println(minMoves);
    }
}
