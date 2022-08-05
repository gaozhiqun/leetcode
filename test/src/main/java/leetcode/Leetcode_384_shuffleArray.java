package leetcode;

import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/9 下午3:17
 */
public class Leetcode_384_shuffleArray {

    class Solution {
        int[] ori, shuffle;
        Random random = new Random();

        public Solution(int[] nums) {
            this.ori = nums;
            this.shuffle = new int[ori.length];
            System.arraycopy(ori, 0, shuffle, 0, ori.length);
        }

        public int[] reset() {
            System.arraycopy(ori, 0, shuffle, 0, ori.length);
            return shuffle;
        }

        public int[] shuffle() {
            for (int i = 0; i < ori.length; ++i) {
                int j = i + random.nextInt(ori.length - i);
                int temp = shuffle[i];
                shuffle[i] = shuffle[j];
                shuffle[j] = temp;
            }
            return shuffle;
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
