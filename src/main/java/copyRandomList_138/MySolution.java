package copyRandomList_138;

import utils.Node;

import java.util.HashMap;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/25 9:23 上午
 */
public class MySolution {
    public Node copyRandomList(Node head){
        if (head == null)
            return null;
//        map储存key为老节点，value为新节点的映射
        HashMap<Node, Node> map = new HashMap<>();
//        辅助节点pre帮助创建新链表
        Node pre = new Node(-1);
        Node tail = pre;
//        从头遍历一遍链表
        while (head != null){
//            如果说head节点在map已经存在，说明之前有某个节点的random指向它提前把它创建出来了，
//            那么新节点的next直接指向它就可以
            if (map.containsKey(head)){
                tail.next = map.get(head);
                tail = tail.next;
//                如果不存在，就创建一个新节点把next指向他，并且把新节点和旧节点head的映射存入map
            }else {
                tail.next = new Node(head.val);
                tail = tail.next;
                map.put(head, tail);
            }
//            如果head的random指向null，不用考虑其他情况，新节点的random也指向random
            if (head.random == null){
                tail.random = null;
            }else {
//                不指向null，那要考虑random指向的节点此时有没有被创建出来
//                如果已经被创建，新random直接指过去
                if (map.containsKey(head.random)) {
                    tail.random = map.get(head.random);
                } else {
//                    如果没创建，创建一个然后把random指过去
                    tail.random = new Node(head.random.val);
                    map.put(head.random, tail.random);
                }
            }
            head = head.next;
        }
        return pre.next;
    }
}
