package LRUCache_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chong
 * @Data: 2021/7/23 6:12 下午
 */
public class Preview {
    private int size;
    private final int capacity;
    private DequeNode head;
    private DequeNode tail;
    private Map<Integer, DequeNode> nodeMap;   // 作为缓存，可以快速找到链表中对应元素

    public Preview(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DequeNode();
        tail = new DequeNode();
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>();
    }



    public int get(int key){
        DequeNode dequeNode = nodeMap.get(key);
        if (dequeNode == null)
            return -1;
        moveToHead(dequeNode);   // 使用了
        return dequeNode.value;
    }

    public void put(int key, int value){
        DequeNode dequeNode = nodeMap.get(key);
        if (dequeNode == null){
            dequeNode = new DequeNode(key, value);
            nodeMap.put(key, dequeNode);

            addToHead(dequeNode);
            size++;
            if (size > capacity){
                DequeNode node = removeTail();
                nodeMap.remove(node.key);
                size--;
            }
        }else {
            dequeNode.value = value;
            moveToHead(dequeNode);
        }
    }



    public void addToHead(DequeNode node){    // 把新加入的元素放在LRU队列头部
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(DequeNode node){   // 队列中的元素被使用过就要更新它到队列头部，表示最近被使用
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DequeNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DequeNode removeTail(){   // 在队列为满时，删掉队列末尾元素，即最近最少未使用的元素
        DequeNode removed = tail.prev;
        removeNode(removed);
        return removed;
    }


    static class DequeNode{
        int key;
        int value;
        DequeNode prev;
        DequeNode next;

        public DequeNode() {
        }

        public DequeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
