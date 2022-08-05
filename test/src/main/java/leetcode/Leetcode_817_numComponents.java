package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_817_numComponents {

    public static void main(String[] args) {
        Leetcode_817_numComponents l = new Leetcode_817_numComponents();
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        ListNode cur = head;
        int ret = 0;
        while (cur != null) {
            boolean flag = false;
            while (cur != null && set.contains(cur.val)) {
                cur = cur.next;
                flag = true;
            }
            if (flag) {
                ++ret;
            } else {
                cur = cur.next;
            }
        }
        return ret;
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