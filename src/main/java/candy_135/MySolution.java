package candy_135;

import org.junit.Test;

import java.util.Random;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/17 3:21 下午
 */
public class MySolution {
    public int candy(int[] ratings) {
        int res = 0;
        int[] candy = new int[ratings.length];

        // 初始给所有孩子一颗糖果,满足条件1
        for (int i = 0; i < candy.length; i++){
            candy[i] = 1;
        }

        // 先从左往右遍历，首先满足一个孩子比他左边孩子评分高就多糖的规则（第一个孩子可以忽略了，因为他左边没孩子）
        // 满足条件二的第一部分
        for (int i = 1; i < candy.length; i++){
            if (ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }

        // 然后从右往左遍历，满足一个孩子比他右边孩子评分高就多糖的规则（最后一个孩子也可以忽略）
        // 满足条件二的第二部分
        for (int i = candy.length - 2; i >= 0; i--){
            // 注意这里的第二个判断：如果糖以及比左孩子多了，自然不用再考虑，此种情况只在最后一次遍历会出现，比如[1,2,3,2,1]这种例子
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
                candy[i] = candy[i + 1] + 1;
            }
        }
        for (int num : candy){
            res += num;
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 4, 5, 2};
        int res = candy(nums);
        System.out.println(res);
    }
}
