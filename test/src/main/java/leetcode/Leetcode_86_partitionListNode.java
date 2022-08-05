package leetcode;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_86_partitionListNode {

    public static void main(String[] args) {
        Leetcode_86_partitionListNode l = new Leetcode_86_partitionListNode();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode g = new ListNode(), s = new ListNode(), gt = g, st = s;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                st.next = head;
                st = st.next;
            } else {
                gt.next = head;
                gt = gt.next;
            }
            head = next;
        }
        st.next = g.next;
        return s.next;
    }

    public class ListNode {
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
