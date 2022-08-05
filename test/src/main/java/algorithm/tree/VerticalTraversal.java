package algorithm.tree;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午8:06
 */
public class VerticalTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((a, b) ->
                a.col == b.col ?
                        a.depth == b.depth ?
                                Integer.compare(a.node.val, b.node.val) :
                                Integer.compare(a.depth, b.depth) :
                        Integer.compare(a.col, b.col));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            priorityQueue.offer(cur);
            if (cur.node.left != null) {
                queue.offer(new Node(cur.node.left, cur.depth + 1, cur.col - 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Node(cur.node.right, cur.depth + 1, cur.col + 1));
            }
        }
        int col = priorityQueue.peek().col;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ans.add(temp);
        while (!priorityQueue.isEmpty()) {
            Node next = queue.poll();
            if (col != next.col) {
                temp = new ArrayList<>();
                ans.add(temp);
                col = next.col;
            }
            temp.add(next.node.val);
        }
        return ans;
    }


    public static class Node {
        TreeNode node;
        int depth;
        int col;

        public Node(TreeNode node, int depth, int col) {
            this.node = node;
            this.depth = depth;
            this.col = col;
        }
    }
}
