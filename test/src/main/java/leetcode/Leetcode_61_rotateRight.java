package leetcode;


import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_61_rotateRight {

    public static void main(String[] args) {
        Leetcode_61_rotateRight l = new Leetcode_61_rotateRight();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode ans = l.rotateRight(node1, 2);
    }

    /**
     * 细节！边界条件掌握好！
     *
     */

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int l = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++l;
        }
        k %= l;
        if (k == 0) {
            return head;
        }
        ListNode newNode = head;
        for (int i = 1; i < l - k; ++i) {
            newNode = newNode.next;
        }
        ListNode newHead = newNode.next;
        newNode.next = null;
        tail.next = head;
        return newHead;
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

}
