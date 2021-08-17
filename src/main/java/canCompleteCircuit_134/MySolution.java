package canCompleteCircuit_134;

import org.junit.Test;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/5 3:24 下午
 */
public class MySolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0){
            return -1;
        }

        int len = gas.length;
        // minus是gas-cost的结果，代表经过每个站点油箱里面所增加油的盈亏值
        int[] minus = new int[len];
        int sum = 0;    // sum代表总盈亏
        for (int i = 0; i < len; i++){
            minus[i] = gas[i] - cost[i];
            sum += minus[i];
        }

        if (sum < 0){   // 如果总盈亏是负数，那么肯定无法环绕一周，直接返回-1
            return -1;
        }

        for (int i = 0; i < len; i++){
            if (minus[i] >= 0){   // 只有minus大于等于0也就是盈亏为正的时候才可能作为出发点
                int val = 0;   // 记录沿途的油箱盈余，如果出现了负数，直接判定这个出发点走不通
                for (int j = i; j < i + len; j++){  // 要遍历一周，所以范围是i + len，利用求余操作模拟环
                    val += minus[j % len];
                    if (val < 0){
                        break;
                    }
                }
                if (val >= 0){ // 说明遍历了一周没有出现过负数，可以走通，此时的i就是出发点
                    return i;
                }
            }
        }

        // 遍历完成也没找到出发点，说明走不通
        return -1;
    }


    @Test
    public void test(){
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
