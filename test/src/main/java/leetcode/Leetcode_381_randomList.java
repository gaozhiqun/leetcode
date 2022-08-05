package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/9 下午3:17
 */
public class Leetcode_381_randomList {

    class Solution {

        /**
         * 每个节点被选的概率一样, 水塘抽样
         *
         * @param head
         */

        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        public int getRandom() {
            ListNode cur = head;
            int idx = 1;
            int ans = cur.val;
            while (cur != null) {
                int next = random.nextInt(idx);
                if (next == 0) {
                    ans = cur.val;
                }
                cur = cur.next;
                ++idx;
            }
            return ans;
        }
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
