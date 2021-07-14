import org.junit.Test;
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
    private List<Integer> unsafeList = new ArrayList<>();

    @Test
    public void test() throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        HashMap map = new HashMap<Integer, Integer>(24);
//        map.put(1, 2);
        Class<? extends HashMap> aClass = map.getClass();
        Field table = aClass.getDeclaredField("table");
        table.setAccessible(true);
        System.out.println(table.get(map));
    }
}
