package algorithm.niuke;

import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/17 下午10:39
 */
public class PailList {


    public boolean isPail(ListNode head) {
        ListNode b = copyAndReverse(head);
        while (head != null) {
            if (b.val != head.val) {
                return false;
            }
            head = head.next;
            b = b.next;
        }
        return true;
    }

    private ListNode copyAndReverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = pre;
            pre = newNode;
            head = head.next;
        }
        return pre;
    }


    public static class ListNode {

        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        pre.next = null;
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            ListNode next = fast.next;
            ListNode next2 = slow.next;
            fast.next = slow;
            slow.next = next;
            fast = next;
            slow = next2;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        PailList pailList = new PailList();
        System.out.println(pailList.solve("172.16.254.1"));
    }

    public String solve(String IP) {
        // write code here
        if (validateIpv4(IP)) {
            return "IPv4";
        } else if (validateIpv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validateIpv4(String ip) {
        String[] digits = ip.split("\\.");
        if (digits.length != 4) {
            return false;
        }
        for (String d : digits) {
            if ("".equals(d) || d.startsWith("0") && !"0".equals(d)) {
                return false;
            }
            try {
                int n = Integer.parseInt(d);
                if (n < 0 || n > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIpv6(String ip) {
        String[] digits = ip.split(":");
        if (digits.length != 8) {
            return false;
        }
        for (String d : digits) {
            if ("".equals(d) || d.length() > 4 || d.startsWith("0") && !"0".equals(d)) {
                return false;
            }
            for (char ch : d.toCharArray()) {
                boolean expr = (ch >= '0' && ch <= '9')
                        || (ch >= 'a' && ch <= 'f')
                        || (ch >= 'A' && ch <= 'F');
                if (!expr) {
                    return false;
                }
            }
        }
        return true;
    }

}
