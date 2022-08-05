package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_203_removeElements {

    public static void main(String[] args) {
        Leetcode_203_removeElements l = new Leetcode_203_removeElements();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode r = l.ReverseList(node1);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }


    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head, next = null;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                next = cur.next;
                pre = cur;
                cur = next;
            }
        }
        return dummyHead.next;
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