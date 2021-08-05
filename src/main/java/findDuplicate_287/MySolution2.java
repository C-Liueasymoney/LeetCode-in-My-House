package findDuplicate_287;

import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;
import org.junit.Test;
import sun.jvm.hotspot.debugger.Page;

/**
 * @Description:
 * 快慢指针
 * @Author: chong
 * @Data: 2021/7/19 5:33 下午
 */
public class MySolution2 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        // 变成了一个有环链表寻找入环节点问题，首先快慢指针行动，有环会相遇，然后慢指针停在相遇处，快指针重新从头开始走(每次只走一步)，再相遇处就是入环节点
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow){
                break;
            }
        }

        fast = 0;
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    @Test
    public void test(){
        int[] nums = {3, 1, 3, 4, 2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
}
