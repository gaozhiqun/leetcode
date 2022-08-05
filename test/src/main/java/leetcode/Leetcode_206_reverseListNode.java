package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_206_reverseListNode {

    public static void main(String[] args) {
        Leetcode_206_reverseListNode l = new Leetcode_206_reverseListNode();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode ans = l.reverseList(head);
        System.out.println(ans.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, next;
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


    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val);
            head = head.next;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;

    }


}