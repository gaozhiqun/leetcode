package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_138_circleListNode {

    public static void main(String[] args) {
        Leetcode_138_circleListNode l = new Leetcode_138_circleListNode();
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        ListNode head2 = new ListNode(5);
        ListNode node20 = new ListNode(6);
        ListNode node21 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        head2.next = node20;
        node20.next = node21;


        ListNode ans = l.addTwoNumbers(head, head2);
        System.out.println(ans.val);

        head = l.sortList(head);
        System.out.println(head);
        head = l.insertionSortList(null);
        System.out.println(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * L0 → L1 → … → Ln-1 → Ln
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        ListNode pre = slow;
        slow = reverse(slow.next);
        pre.next = null;
        while (fast != null && slow != null) {
            ListNode anext = fast.next;
            ListNode bnext = slow.next;
            fast.next = slow;
            fast = anext;
            slow.next = fast;
            slow = bnext;
        }
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            insert(dummyHead, head);
            head = next;
        }
        return dummyHead.next;

    }

    private void insert(ListNode dummyHead, ListNode target) {
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.val < target.val) {
            pre = pre.next;
        }
        ListNode next = pre.next;
        pre.next = target;
        target.next = next;
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode forward = new ListNode(-1);
        ListNode pre = forward;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next = l1.next;
                pre.next = l1;
                l1.next = null;
                pre = l1;
                l1 = next;
            } else {
                ListNode next = l2.next;
                pre.next = l2;
                l2.next = null;
                pre = l2;
                l2 = next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return forward.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 0, n = 0;
        ListNode a = headA, b = headB;
        while (a.next != null) {
            ++m;
            a = a.next;
        }

        while (b.next != null) {
            ++n;
            b = b.next;
        }

        if (a != b) {
            return null;
        }

        if (m > n) {
            for (int i = 0; i < m - n; ++i) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < n - m; ++i) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;

        }
        return headA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int val = n1 != null && n2 != null ? n1.val + n2.val + carry : n1 != null ? n1.val + carry : n2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

/**
 * Definition for singly-linked list.
 */
}