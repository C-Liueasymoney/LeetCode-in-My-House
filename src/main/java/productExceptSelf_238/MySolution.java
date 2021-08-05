package productExceptSelf_238;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/16 6:58 下午
 */
public class MySolution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 创建左右前缀数组，i位置上分别对应nums[i]的前缀和后缀乘积
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;   // 第0位没有前缀，设为1
        for (int i = 1; i < length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 最后的结果就是left和right对应位置上相乘的结果
        for (int i = 0; i < length; i++){
            left[i] = left[i] * right[i];    // 这里不开新数组了，直接用left当结果
        }
        return left;
    }
}
