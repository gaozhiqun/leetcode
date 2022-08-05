package algorithm.niuke;

import algorithm.ListNodeMap;
import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/16 下午2:31
 */
public class FindFirstCommonNode {


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int l1 = 0, l2 = 0;
        while (cur1 != null) {
            ++l1;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            ++l2;
            cur2 = cur2.next;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; ++i) {
                cur1 = cur1.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; ++i) {
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    public static class ListNode {

        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode list1 = reverse(head1);
        ListNode list2 = reverse(head2);
        int carry = 0;
        ListNode pre = null, newHead = null;
        while (list1 != null || list2 != null) {
            int val = carry;
            if (list1 != null) {
                val += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                val += list2.val;
                list2 = list2.next;
            }
            ListNode newNode = new ListNode(val % 10);
            carry = val / 10;
            if (pre != null) {
                pre.next = newNode;
            }
            pre = newNode;
            if (newHead == null) {
                newHead = pre;
            }
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            pre.next = newNode;
        }
        return reverse(newHead);
    }


    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(5);
        node11.next = node12;
        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        findFirstCommonNode.reverseBetween(node11, 1, 2);


    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m == n) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, l = head, r = head, next = r.next;
        for (int i = 0; i < n - 1; ++i) {
            if (i < m - 1) {
                pre = l;
                l = l.next;
            }
            r = r.next;
            next = r.next;
        }
        ListNode[] nodes = reverse(l, r);
        pre.next = nodes[0];
        nodes[1].next = next;
        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head, fianlTail = tail.next;
        while (cur != fianlTail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        LinkedList<Interval> ret = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(a -> a.end));
        for (Interval interval : intervals) {
            if (ret.isEmpty()) {
                ret.addLast(interval);
            } else {
                while (!ret.isEmpty() && ret.peekLast().end >= interval.start) {
                    Interval pre = ret.pollLast();
                    interval = new Interval(Math.min(pre.start, interval.start),
                            Math.max(pre.end, interval.end));
                }
                ret.addLast(interval);
            }
        }
        return new ArrayList<>(ret);

    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public ListNode oddEvenList(ListNode head) {
        // write code here
        ListNode odds = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode cur1 = odds, cur2 = even;
        int i = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (i % 2 != 0) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = next;
            ++i;
        }
        cur2.next = odds.next;
        return even.next;
    }


}
