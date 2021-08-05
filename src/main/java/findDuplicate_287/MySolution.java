package findDuplicate_287;

/**
 * @Description:
 * 二分法
 * @Author: chong
 * @Data: 2021/7/19 5:18 下午
 */
public class MySolution {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            // 先找到数组中的中点，把数组一份为二
            int mid = left + ((right - left) >> 1);

            int count = 0;
            // 根据题目给出的特点，1～n的数字遍布在n+1长度的范围
            for (int num : nums){
                if (num <= mid){
                    count++;
                }
            }

            if (count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
