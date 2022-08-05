package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_325_oddEvenList {

    public static void main(String[] args) {
        Leetcode_325_oddEvenList l = new Leetcode_325_oddEvenList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newNode = l.oddEvenList(node1);
        while (newNode.next != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odds = new ListNode();
        ListNode dummyoddHead = odds;
        ListNode evens = new ListNode();
        ListNode dummyevenHead = evens;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            odds.next = head;
            head = next;
            odds = odds.next;
            if (head != null) {
                next = head.next;
                head.next = null;
                evens.next = head;
                evens = evens.next;
                head = next;
            }
        }
        odds.next = dummyevenHead.next;
        return dummyoddHead.next;
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