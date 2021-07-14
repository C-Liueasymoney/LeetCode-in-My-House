package maxProduct_152;


import org.junit.Test;

/**
 * @Description:
 * 这中方法利用两个dp来回交换，保存了负数
 * @Author: chong
 * @Data: 2021/7/7 5:42 下午
 */
public class MySolution {
    public int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums){
            if (num < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(num * imax, num);
            imin = Math.min(num * imin, num);

            max = Math.max(imax, max);
        }
        return max;
    }

    @Test
    public void test(){
        int[] nums = {2, 3, -6, 5, -2};
        int res = maxProduct(nums);
        System.out.println(res);
    }
}
