package LRUCache_146;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/6/26 12:00 下午
 */
public class MySolution {
    private int size;
    private Map<Integer, ListNode> map;
    private ListNode head, tail;
    public MySolution(int capacity){
        this.size = capacity;
        map = new HashMap<>(size);
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null){
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > size){
                ListNode tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(ListNode node){
        node.next = head;
        head.pre = node;
        node = head;
    }

    private void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(ListNode node){
        removeNode(node);
        addToHead(node);
    }

    private ListNode removeTail(){
        ListNode temp = tail;
        tail = tail.pre;
        removeNode(temp);
        return temp;
    }

    public static void main(String[] args) {
        MySolution test = new MySolution(2);
        System.out.println(test.get(1));
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1));
        test.put(3, 3);
        System.out.println(test.get(2));
    }
}

class ListNode{
    int key;
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(int key, int val){
        this.key = val;
        this.val = val;
    }
}
