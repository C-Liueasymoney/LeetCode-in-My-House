package findMedianSortedArray_4;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/4 4:52 下午
 */
public class MySolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int[] aux = new int[nums1.length + nums2.length];
        double result;

        int i = 0;
        int j = 0;
        for (int k = 0; k < aux.length; k++){
            if (i >= nums1.length){
                aux[k] = nums2[j++];
            }else if (j >= nums2.length){
                aux[k] = nums1[i++];
            }else if (nums1[i] > nums2[j]){
                aux[k] = nums2[j++];
            }else {
                aux[k] = nums1[i++];
            }
        }

        if (aux.length % 2 == 0){
            result = (double) (aux[aux.length / 2] + aux[aux.length / 2 - 1]) / 2;
        }else {
            result = aux[aux.length / 2];
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums1 = {};
        int[] nums2 = {2};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
