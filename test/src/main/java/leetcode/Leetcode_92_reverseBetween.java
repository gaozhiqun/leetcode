package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_92_reverseBetween {

    /**
     * 10
     */

    public static void main(String[] args) {
        Leetcode_92_reverseBetween l = new Leetcode_92_reverseBetween();
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(5);
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        ListNode ans = l.reverseBetween(node10, 2, 4);
        System.out.println(ans);
        ListNode node20 = new ListNode(3);
        ListNode node21 = new ListNode(5);
        node20.next = node21;
        ans = l.reverseBetween(node20, 1, 2);
        System.out.println(ans);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre, next = rightNode;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
            next = rightNode.next;
        }
        ListNode[] nodes = reverse(pre.next, rightNode);
        pre.next = nodes[0];
        nodes[1].next = next;
        return dummyNode.next;
    }


    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next, cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
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
