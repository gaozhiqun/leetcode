package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_82_deleteDuplicates {

    public static void main(String[] args) {
        Leetcode_82_deleteDuplicates l = new Leetcode_82_deleteDuplicates();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        //ListNode node6 = new ListNode(4);
        // ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;
        //node6.next = node7;
        ListNode ans = l.deleteDuplicates(node1);
        System.out.println(ans.val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(101), pre = dummyHead, prePre = null;
        int val = 101;
        while (head != null) {
            if (val == head.val) {
                pre = prePre;
                pre.next = null;
            } else {
                prePre = pre;
                pre.next = head;
                pre = head;
                val = pre.val;
            }
            head = head.next;
        }
        return dummyHead.next;
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

    public ListNode deleteDuplicatesSimple(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(101), pre = dummyHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (pre.val != head.val) {
                pre.next = head;
                pre = head;
            }
            head = next;
        }
        return dummyHead.next;
    }

}
