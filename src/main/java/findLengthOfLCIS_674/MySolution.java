package findLengthOfLCIS_674;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/8 3:11 下午
 */
public class MySolution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1]){
                res++;
            }else {
                res = 1;
            }

            max = Math.max(max, res);
        }
        return max;
    }
}
