package sortedArrayToBST_108;

import utils.TreeNode;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/27 5:16 下午
 */
public class MySolution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int left, int right){
        if (left > right)
            return null;

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);

        root.left = process(nums, left, mid - 1);
        root.right = process(nums, mid + 1, right);

        return root;
    }
}
