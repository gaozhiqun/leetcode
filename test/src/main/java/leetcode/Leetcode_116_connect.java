package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_116_connect {
    public static void main(String[] args) {
        Leetcode_116_connect l = new Leetcode_116_connect();
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node head = null;
            for (int i = 0; i < n; ++i) {
                Node pre = queue.poll();
                pre.next = head;
                head = pre;
                if (pre.right != null) {
                    queue.offer(pre.right);
                }
                if (pre.left != null) {
                    queue.offer(pre.left);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

}
