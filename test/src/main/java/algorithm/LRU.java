package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/14 下午5:26
 */
public class LRU {
    /**
     * ["set","set","get","set","get","set","get","get","get"],[[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]],2
     * <p>
     * ["set","set","get","set","get","set","get","get","get"],
     * [[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]],
     * 2
     *
     * @param args
     */
    public static void main(String[] args) {
        LRU.Solution solution = new LRU.Solution(2);
        solution.set(1, 0);
        solution.set(2, 2);
        System.out.println(solution.get(1));
        solution.set(3, 3);
        System.out.println(solution.get(2));
        solution.set(4, 4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
    }

    public static class ListEntry {
        final int key;
        int val;
        ListEntry next;
        ListEntry pre;

        ListEntry(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    public static class Solution {

        private final int capacity;

        private int size;

        private final ListEntry dummyHead;
        private final ListEntry dummyTail;
        private final Map<Integer, ListEntry> map;

        public Solution(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            dummyHead = new ListEntry(Integer.MIN_VALUE, -1);
            dummyTail = new ListEntry(Integer.MAX_VALUE, -1);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            map = new HashMap<>();
            // write code here
        }

        public int get(int key) {
            ListEntry node = map.get(key);
            if (node == null) {
                return -1;
            }
            move2Head(node);
            return node.val;
            // write code here
        }

        public void set(int key, int value) {
            ListEntry node = map.get(key);
            if (node == null) {
                ListEntry newNode = new ListEntry(key, value);
                ++size;
                insertHead(newNode);
                map.put(key, newNode);
                if (size > capacity) {
                    removeLast();
                }
            } else {
                node.val = value;
                move2Head(node);
            }
            // write code here
        }

        private void move2Head(ListEntry cur) {
            unLink(cur);
            insertHead(cur);
        }

        private void removeLast() {
            ListEntry last = dummyTail.pre;
            map.remove(last.key);
            unLink(last);
            --size;
        }

        private void insertHead(ListEntry cur) {
            ListEntry next = dummyHead.next;
            dummyHead.next = cur;
            cur.next = next;
            cur.pre = dummyHead;
            next.pre = cur;
        }

        private void unLink(ListEntry cur) {
            ListEntry pre = cur.pre;
            ListEntry next = cur.next;
            pre.next = next;
            next.pre = pre;
            cur.next = null;
            cur.pre = null;
        }
    }
}
