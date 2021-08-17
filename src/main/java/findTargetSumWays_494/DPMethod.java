package findTargetSumWays_494;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/11 8:33 下午
 */
public class DPMethod {
    public int findTargetSumWays(int[] nums, int target) {
        // sum是nums取值范围的绝对值，比如nums=[1,1,1]，那么他们的和最多是+1+1+1=3,最少是-1-1-1=-3取之范围就是-3～3
        // 我们想要这个结果等于target，实际上就是求dp数组上index = nums.length - 1 且 sum + target的位置的值
        // 举个上面的例子：如果target=1,那么就是最后我要sum和是1，即如[-1，1，-1]这样的组合，当然了数组下标不能有负数，
        // 所以我们把sum * 2 + 1，用sum代表原来的0位置，sum以下是原来的负数，以上是原来的正数
        int sum = 0;
        for (int num : nums){
            sum += num;
        }

        if (Math.abs(sum) < target){
            return 0;
        }

        int[][] dp = new int[2 * sum + 1][nums.length];
//        if (nums[0] == 0){
//            dp[sum][0] = 2;
//        }else {
//            dp[sum + nums[0]][0] = 1;
//            dp[sum - nums[0]][0] = 1;
//        }
        // 初始化，index=0时，肯定只有+-nums[0]两个结果
        dp[sum + nums[0]][0]++;    // 这里用++是为了防止nums[0]=0，导致两个位置是一样的
        dp[sum - nums[0]][0]++;

        for (int index = 1; index < nums.length; index++){
            for (int s = 0; s < dp.length; s++){
                // 边界处理
                int low = s - nums[index] >= 0 ? s - nums[index] : 0;
                int high = s + nums[index] < 2 * sum + 1 ? s + nums[index] : 0;
                dp[s][index] = dp[high][index - 1] + dp[low][index - 1];
            }
        }

        return dp[sum + target][nums.length - 1];
    }

    @Test
    public void test() {
        int[] nums = {1};
        int res = findTargetSumWays(nums, 2);
        System.out.println(res);
    }
}
