package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 下午8:16
 */
public class Leetcode_952_largestComponentSize {
    public static void main(String[] args) {
        Leetcode_952_largestComponentSize l = new Leetcode_952_largestComponentSize();
        System.out.println(l.largestComponentSize(new int[]{
                4, 6, 15, 35
        }));
        System.out.println(l.largestComponentSize(new int[]{
                20, 50, 9, 63
        }));
        System.out.println(l.largestComponentSize(new int[]{
                83, 99, 39, 11, 19, 30, 31
        }));
    }

    int[] parent;
    int[] cnts;
    Map<Integer, Integer> seenMap;

    public int largestComponentSize(int[] nums) {
        int N = nums.length;
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
        cnts = new int[N];
        Arrays.fill(cnts, 1);
        seenMap = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            int d = 2, x = nums[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0) {
                        x /= d;
                    }
                    checkOrUnion(i, d);
                }
                d++;
            }
            if (x > 1) {
                checkOrUnion(i, x);
            }
        }
        return Arrays.stream(cnts).max().getAsInt();
    }

    private void checkOrUnion(int i, int d) {
        if (seenMap.containsKey(d)) {
            union(i, seenMap.get(d));
        } else {
            seenMap.put(d, i);
        }
    }

    private void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2) {
            return;
        }
        parent[p2] = p1;
        cnts[p1] += cnts[p2];
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    /**
     * 恰好重复N次 2N中
     *
     * @param nums
     * @return
     */

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : nums) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
            if (cnts.get(i) == (nums.length / 2)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.val * 2));
                nodes.add(new ANode(anode.node.right, anode.val * 2 + 1));
            }
        }

        return nodes.get(i - 1).val == nodes.size();
    }

    public static class ANode {
        private int val;
        TreeNode node;

        public ANode(TreeNode node, int val) {
            this.val = val;
            this.node = node;
        }
    }


}
