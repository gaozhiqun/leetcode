package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/13 下午2:55
 */
public class Leetcode_432_AllOne {
    public static void main(String[] args) {
        Leetcode_432_AllOne l = new Leetcode_432_AllOne();

    }

    public static class AllOne {
        private Map<String, Integer> cache; //this is to map string to its frequency;
        private Map<Integer, DLNode> freq; // this is to map the frequency to a double linked list node which stores the strings with the same frequency;
        private DLNode head, tail; // the head and tail of the DLNode list; node with higher frequency is in front of the list

        private class DLNode {
            int val;
            Set<String> keys;
            DLNode pre, next;

            public DLNode(int val) {
                this.val = val;
                this.keys = new HashSet<>();
            }
        }

        public AllOne() {
            cache = new HashMap<>();
            freq = new HashMap<>();
            head = new DLNode(0);
            tail = new DLNode(0);
            head.next = tail;
            tail.pre = head;
        }

        public void inc(String key) {
            if (cache.containsKey(key)) {
                int val = cache.get(key);
                cache.put(key, val + 1);
                DLNode node = freq.get(val);
                node.keys.remove(key); // remove the key from the original node;
                DLNode preNode = node.pre;
                if (preNode == head || preNode.val > val + 1) {
                    DLNode newNode = new DLNode(val + 1);
                    newNode.keys.add(key);
                    newNode.next = node;
                    node.pre = newNode;
                    newNode.pre = preNode;
                    preNode.next = newNode;
                    freq.put(val + 1, newNode);
                    preNode = newNode;
                } else {
                    preNode.keys.add(key);
                }
                if (node.keys.size() == 0) {
                    preNode.next = node.next;
                    node.next.pre = preNode;
                    freq.remove(val);
                }
            } else {
                cache.put(key, 1);
                DLNode node = freq.get(1);
                if (node == null) {
                    DLNode newNode = new DLNode(1);
                    newNode.keys.add(key);
                    tail.pre.next = newNode;
                    newNode.pre = tail.pre;
                    newNode.next = tail;
                    tail.pre = newNode;
                    freq.put(1, newNode);
                } else {
                    node.keys.add(key);
                }
            }
        }

        public void dec(String key) {
            if (cache.containsKey(key)) {
                int val = cache.get(key);
                DLNode node = freq.get(val);
                node.keys.remove(key);
                if (val == 1) {
                    cache.remove(key);
                } else {
                    cache.put(key, val - 1);
                    DLNode nextNode = node.next;
                    if (nextNode == tail || nextNode.val < val - 1) {
                        DLNode newNode = new DLNode(val - 1);
                        newNode.keys.add(key);
                        node.next = newNode;
                        newNode.pre = node;
                        newNode.next = nextNode;
                        nextNode.pre = newNode;
                        freq.put(val - 1, newNode);
                    } else {
                        nextNode.keys.add(key);
                    }
                }
                if (node.keys.size() == 0) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    freq.remove(val);
                }
            }
        }

        public String getMaxKey() {
            if (head.next == tail) {
                return "";
            } else {
                return head.next.keys.iterator().next();
            }
        }

        public String getMinKey() {
            if (head.next == tail) {
                return "";
            } else {
                return tail.pre.keys.iterator().next();
            }
        }
    }
}

