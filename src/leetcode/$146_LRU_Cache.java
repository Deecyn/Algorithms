package leetcode;

import java.util.HashMap;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $146_LRU_Cache {

    class Node {
        public int key, value;
        public Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    class LRUCache {
        private HashMap<Integer, Node> hashMap;
        private DoubleList cacheList;
        private int capacity;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<>(capacity);
            cacheList = new DoubleList();
        }

        public int get(int key) {
            if (!hashMap.containsKey(key)) {
                return -1;
            }
            int val = hashMap.get(key).value;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);

            if (hashMap.containsKey(key)) {
                cacheList.remove(hashMap.get(key));
            } else {
                if (cacheList.size() == capacity) {
                    Node last = cacheList.removeLast();
                    hashMap.remove(last.key);
                }
            }
            cacheList.addFirst(node);
            hashMap.put(key, node);
        }
    }

}
