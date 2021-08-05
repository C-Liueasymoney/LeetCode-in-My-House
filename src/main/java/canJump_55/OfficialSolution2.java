package canJump_55;

/**
 * @Description:
 * 贪心策略
 * @Author: chong
 * @Data: 2021/7/28 6:14 下午
 */
public class OfficialSolution2 {
    public boolean canJump(int[] nums){
        int k = 0;    // k代表当前最大能跳到的位置
        for (int i = 0; i < nums.length; i++){
            if (i > k)  // 表示如果当前走到了比最远能到达的k位置还要远的i位置，就返回false
                return false;
            k = Math.max(k, i + nums[i]);  // 更新k为，当前能到达的最远位置，与当前位置下加上此位置能跳的步数中的最大值
        }
        return true;
    }
}
