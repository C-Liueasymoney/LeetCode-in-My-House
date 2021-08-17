package rotateString_796;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/8/10 3:36 下午
 */
public class MySolution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }

        s += s;   // 如： abcde -> abcdeabcde
//        // 此时看goal是否是s的子串就行，因为此时s任意长度为5的子串都是它的旋转词
//        return s.contains(goal);
        return kmp(s, goal) != -1;
    }


    public int kmp(String s, String p){
        char[] sk = s.toCharArray();
        char[] pk = p.toCharArray();
        int si = 0;
        int pi = 0;

        int[] next = getNext(p);

        while (si < s.length() && pi < p.length()){
            if (sk[si] == pk[pi]){
                si++;
                pi++;
            }else if (next[pi] == -1){
                si++;
            }else {
                pi = next[pi];
            }
        }

        return pi == p.length() ? si - pi : -1;
    }

    public int[] getNext(String p){
        if (p.length() == 1){
            return new int[]{-1};
        }

        int[] next = new int[p.length()];
        next[0] = -1;
        next[1] = 0;
        int cur = 0;
        int index = 2;

        while (index < next.length){
            if (p.charAt(index - 1) == p.charAt(next[index - 1])){
                next[index++] = ++cur;
            }else if (cur > 0){
                cur = next[cur];
            }else {
                next[index++] = 0;
            }
        }
        return next;
    }
}
