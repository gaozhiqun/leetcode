package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/12 上午10:26
 */
public class Leetcode_725_splitListToParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] tails = new ListNode[k];
        ListNode[] ret = new ListNode[k];
        int i = 0;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (tails[i % k] == null) {
                tails[i % k] = cur;
                ret[i % k] = cur;
            } else {
                tails[i % k].next = cur;
                tails[i % k] = cur;
            }
            cur = next;
            ++i;
        }
        return ret;
    }

    public ListNode[] splitListToParts2(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        int m = len / k;
        int n = len % k;
        ListNode[] ret = new ListNode[k];
        cur = head;
        for (int j = 0; j < k && cur != null; j++) {
            ret[j] = cur;
            int size = m + (j < n ? 1 : 0);
            for (int i = 1; i < size; ++i) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
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
