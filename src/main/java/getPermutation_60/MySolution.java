package getPermutation_60;

import org.junit.Test;

import java.rmi.server.RMIServerSocketFactory;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/10 4:30 下午
 */
public class MySolution {
    String res;
    int count;
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        count = 0;
        process(n, k, 0, used, new StringBuilder());
        return res;
    }

    public void process(int n, int k, int depth, boolean[] used, StringBuilder str){
        if (count > k){
            return;
        }
        if (depth == n){
            count++;
            if (count == k){
                res = str.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++){
            if (!used[i - 1]){
                str.append(i);
                used[i - 1] = true;
                process(n, k, depth + 1, used, str);
                str.delete(str.length() - 1, str.length());
                used[i - 1] = false;
            }
        }
    }

    @Test
    public void test(){
        String res = getPermutation(4, 9);
        System.out.println(res);
    }
}
