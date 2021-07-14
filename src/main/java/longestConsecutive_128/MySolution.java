package longestConsecutive_128;

import org.junit.Test;

import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/8 3:56 下午
 */
public class MySolution {
    private Map<Integer, Element> map = new HashMap<>();
    private Map<Element, Element> fartherMap = new HashMap<>();
    private Map<Element, Integer> sizeMap = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        for (int num : nums){
            Element element = new Element(num);
            map.put(num, element);
            fartherMap.put(element, element);
            sizeMap.put(element, 1);
        }

        for (int num : nums){
            union(num, num + 1);
            union(num, num - 1);
        }

        int longest = 0;

        for (Map.Entry<Element, Integer> entry : sizeMap.entrySet()){
            longest = Math.max(longest, entry.getValue());
        }

        return longest;
    }

    public boolean isSameSet(Integer a, Integer b){
        if (map.containsKey(a) && map.containsKey(b)){
            return findHead(map.get(a)) == findHead(map.get(b));
        }
        return false;
    }


    public void union(Integer a, Integer b){
        if (map.containsKey(a) && map.containsKey(b)){
            Element aFather = findHead(map.get(a));
            Element bFather = findHead(map.get(b));

            if (aFather != bFather){
                Element big = sizeMap.get(aFather) >= sizeMap.get(bFather) ? aFather : bFather;
                Element small = big == aFather ? bFather : aFather;

                fartherMap.put(small, big);

                sizeMap.put(big, sizeMap.get(aFather) + sizeMap.get(bFather));
                sizeMap.remove(small);
            }
        }
    }



    public Element findHead(Element element){
        LinkedList<Element> path = new LinkedList<>();
        while (fartherMap.get(element) != element){
            path.push(element);
            element = fartherMap.get(element);
        }

        while (!path.isEmpty()){
            fartherMap.put(path.pop(), element);
        }
        return element;
    }


    static class Element{
        private Integer value;

        public Element(Integer value){
            this.value = value;

        }
    }


    @Test
    public void test(){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int res = longestConsecutive(nums);
        System.out.println(res);

    }
}
