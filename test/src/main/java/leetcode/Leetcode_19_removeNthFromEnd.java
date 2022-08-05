package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_19_removeNthFromEnd {
    public static void main(String[] args) {
        Leetcode_19_removeNthFromEnd l = new Leetcode_19_removeNthFromEnd();
        ListNode head = new ListNode(1);
        //System.out.println(l.removeNthFromEnd(head, 1));
        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(l.removeNthFromEnd(head2, 1));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, target = head, cur = head;
        for (int i = 0; i < n - 1; ++i) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = target;
            target = target.next;
        }
        if (pre != null) {
            pre.next = target.next;
            return head;
        } else {
            return head.next;
        }

    }

    /**
     * Definition for singly-linked list.
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
}

