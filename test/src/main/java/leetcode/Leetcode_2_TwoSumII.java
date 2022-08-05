package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 上午10:49
 */
public class Leetcode_2_TwoSumII {
    public static void main(String[] args) {
        Leetcode_2_TwoSumII leetcode_2_twoSumII = new Leetcode_2_TwoSumII();
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        ListNode result2 = leetcode_2_twoSumII.sum(node11, node21);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        return reverse(sum(reverse1, reverse2));
    }

    public ListNode sum(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0, a = 0;
        ListNode head = null, cur = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                a = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;

            } else if (l2 == null) {
                a = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            } else {
                a = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode node = new ListNode(a);
            if (head == null) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }

    private ListNode reverse(ListNode l) {
        ListNode pre = null, next, cur;
        cur = l;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
}
