package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/5 下午2:36
 */
public class Leetcode_1171_removeZeroSumSublists {


    public static void main(String[] args) {

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;

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
