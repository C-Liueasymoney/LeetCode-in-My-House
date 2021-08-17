package lengthOfLIS_300;

import org.junit.Test;

/**
 * @Description:
 * 二分查找法：时间复杂度O(NlogN)
 * 实际是去使用二分查找来优化动态规划方法，因为在动态规划中，构建DP数组需要时间复杂度O(N)，计算其中每个DP[i]又需要O(N^2)
 * 那很自然的想到能不能使用二分查找来把计算dp[i]步骤的时间复杂度降为O(logN)
 * @Author: chong
 * @Data: 2021/8/8 1:57 下午
 */
public class BinSearch {
    public int lengthOfLIS(int[] nums) {
        // dp不再是对应nums下标位置作为子序列开头或结尾的结果
        // 而是用下标代表子序列长度，保存的是到达该长度时末尾最小元素
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++){
            int left = 0;
            int right = res;    // 双指针查找的是dp中有值的部分
            while (left < right){
                int mid = left + ((right - left) >> 1);
                if (dp[mid] < nums[i]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (right == res)
                res++;
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }
}
