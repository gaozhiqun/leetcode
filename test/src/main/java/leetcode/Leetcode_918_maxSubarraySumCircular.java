package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;


public class Leetcode_918_maxSubarraySumCircular {
    public static void main(String[] args) {
        Leetcode_918_maxSubarraySumCircular l = new Leetcode_918_maxSubarraySumCircular();
        System.out.println(l.maxSubarraySumCircular(new int[]{
                1, -2, 3, -2
        }));
        System.out.println(l.maxSubarraySumCircular(new int[]{
                5, -3, 5
        }));
        System.out.println(l.maxSubarraySumCircular(new int[]{
                3, -2, 2, -3
        }));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int N = nums.length;
        int[] sum = new int[2 * N + 1];
        for (int i = 0; i < 2 * N; ++i) {
            sum[i + 1] = sum[i] + nums[i % N];
        }
        int ans = nums[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for (int j = 1; j <= 2 * N; ++j) {
            if (deque.peekFirst() < j - N) {
                deque.pollFirst();
            }
            ans = Math.max(ans, sum[j] - sum[deque.peekFirst()]);
            while (!deque.isEmpty() && sum[j] <= sum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return ans;
    }

    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> deque;
        public CBTInserter(TreeNode root) {
            this.root = root;
            deque = new LinkedList();
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);

            // BFS to populate deque
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null || node.right == null)
                    deque.offerLast(node);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode node = deque.peekFirst();
            deque.offerLast(new TreeNode(v));
            if (node.left == null)
                node.left = deque.peekLast();
            else {
                node.right = deque.peekLast();
                deque.pollFirst();
            }

            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
