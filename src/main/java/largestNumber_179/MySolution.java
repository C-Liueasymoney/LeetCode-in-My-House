package largestNumber_179;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/30 4:02 下午
 */
public class MySolution {
    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            temp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

        if (temp[0].equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        for (String num : temp){
            res.append(num);
        }
        return res.toString();
    }

    @Test
    public void test(){
        int[] nums = {3,30,34,5,9};
        String res = largestNumber(nums);
        System.out.println(res);
    }
}
