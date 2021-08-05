package findMin_154;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/18 11:32 下午
 */
public class MySolution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int res = nums[left];

        if (nums[left] < nums[right]){  // 情况二：发现如果是[1, 2, 3]这种特例直接返回
            return res;
        }

        while (left < right){
            if (right - left == 1){    // 情况一：正常二分到最后，left和right指针相邻时，right指针就是最小值
                res = nums[right];
                break;
            }

            int mid = left + ((right - left) >> 1);
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){  // 三指针相等无法判断最小值在哪个区间，只能遍历查找
                for (int i = left; i <= right; i++){
                    res = Math.min(res, nums[i]);
                }
                break;
            }else if (nums[mid] >= nums[left]){     // 中点mid比left大，说明mid落在左区间，把left拿到mid上去
                left = mid;
            } else if (nums[mid] <= nums[right]){   // 中点mid比right小，说明mid落在右区间，把right拿到mid上去
                right = mid;
            }
        }
        return res;
    }
}
