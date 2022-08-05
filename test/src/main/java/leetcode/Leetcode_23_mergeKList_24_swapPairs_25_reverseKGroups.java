package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_23_mergeKList_24_swapPairs_25_reverseKGroups {
    public static void main(String[] args) {
        Leetcode_23_mergeKList_24_swapPairs_25_reverseKGroups l = new Leetcode_23_mergeKList_24_swapPairs_25_reverseKGroups();
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(5);
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        ListNode ans = l.reverseKGroup(node10, 2);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode first = head, second = head.next, ans = second, pre = null;
        while (second != null) {
            if (pre != null) {
                pre.next = second;
            }
            ListNode next = second.next;
            second.next = first;
            first.next = next;
            pre = first;
            first = pre.next;
            if (first == null) {
                break;
            }
            second = first.next;
        }
        return ans;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue
                = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode l : lists) {
            if (l != null) {
                priorityQueue.offer(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!priorityQueue.isEmpty()) {
            ListNode next = priorityQueue.poll();
            tail.next = next;
            tail = tail.next;
            if (next.next != null) {
                priorityQueue.offer(next.next);
            }
        }
        return head.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode cur = head, prev = tail.next;
        while (prev != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}

