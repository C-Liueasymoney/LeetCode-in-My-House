package longestCommonPrefix_14;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/7 4:08 下午
 */
public class MySolution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int len = prefix.length();
        for (int i = 1; i < strs.length; i++){
            int temp = 0;
            for (int j = 0; j < Math.min(len, strs[i].length()); j++){
                if (strs[i].charAt(j) == prefix.charAt(j)){
                    temp++;
                }else {
                    break;
                }
            }
            len = Math.min(len, temp);
            prefix = prefix.substring(0, len);
        }

        return prefix;
    }
}
