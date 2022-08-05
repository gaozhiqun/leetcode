package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_21_mergeTwoLists {
    public static void main(String[] args) {
        Leetcode_21_mergeTwoLists l = new Leetcode_21_mergeTwoLists();
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        node10.next = node11;
        node11.next = node12;
        ListNode node20 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        node20.next = node21;
        node21.next = node22;
        ListNode ans = l.mergeTwoLists(node10, node20);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }
        ListNode ans = null, cur = null;
        while (l1 != null && l2 != null) {
            ListNode next;
            if (l1.val < l2.val) {
                next = l1;
                l1 = l1.next;
            } else {
                next = l2;
                l2 = l2.next;
            }
            if (ans == null) {
                ans = next;
                cur = next;
            } else {
                cur.next = next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return ans;
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

