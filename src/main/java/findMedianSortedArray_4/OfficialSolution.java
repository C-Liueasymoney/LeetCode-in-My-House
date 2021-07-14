package findMedianSortedArray_4;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/4 5:11 下午
 */
public class OfficialSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
//        k1、k2是数组的两个中位数（从下标1开始计数），如果数组长度为偶数，k1 ！= k2，如果数组长度为奇数 k1 == k2
        int k1 = (nums1.length + nums2.length + 1) / 2;
        int k2 = (nums1.length + nums2.length + 2) / 2;
        return (double) (getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1) +
                getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2)) / 2;
    }

    public int getKth(int[] nums1, int start1, int end1, int[]nums2, int start2, int end2, int k){
//        计算两个数组的长度（其中end和start都是以下标0开始计数，所以最后要加1），数组每轮之后会被排除掉一部分
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
//        保证nums1的长度要比nums2的小，如果大了就交换一下这两个数组的顺序去递归
//        这样就可以保证当一个数组递归到空，首先空的一定是nums1，或者两个数组同时空，就省去了判断nums1还是nums2空的语句
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);

//        如果len1等于0，说明nums1数组递归到空了，那么nums2数组中从start处往后k个就应该是第k个最小元素了
        if (len1 == 0)
            return nums2[start2 + k - 1];
//        当k==1时，不需要再排除掉数组元素了，直接查看nums1和nums2对应位置哪个更小，就是第k小的元素了
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
//        i、j分别是nums1和nums2中应该比较大小的位置
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

//        消除掉较小一方的数组元素
        if (nums1[i] < nums2[j]){
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }else {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
    }

    @Test
    public void test(){
        int[] nums1 = {1};
        int[] nums2 = {};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
