import org.junit.jupiter.api.Test;
import sun.print.PeekGraphics;
import sun.tools.jconsole.MaximizableInternalFrame;
import utils.ListNode;
import utils.Node;
import utils.TreeNode;

import javax.swing.*;
import javax.swing.plaf.SpinnerUI;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.*;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/6 9:47 上午
 */
public class Review {
    public void heapSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        for (int i = 1; i < nums.length; i++){
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    public void heapInsert(int[] nums, int index){
        while (nums[(index - 1) / 2] < nums[index]){
            swap(nums, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(nums, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test(){
        int[] nums = {5, 9, 1, -4, 5, 3, 7, 6, 1, 32, 23, 42, 57, 2, -49, 4, 67};

        heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
