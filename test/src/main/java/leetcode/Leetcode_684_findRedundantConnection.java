package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_684_findRedundantConnection {

    public static void main(String[] args) {
        Leetcode_684_findRedundantConnection l = new Leetcode_684_findRedundantConnection();
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        int[] ans = null;
        for (int[] edge : edges) {
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            if (find(i, parent) == find(j, parent)) {
                ans = edge;
            } else {
                union(i, j, parent);
            }
        }
        return ans;
    }

    private int find(int i, int[] parent) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    private void union(int i, int j, int[] parent) {
        int p1 = find(i, parent);
        int p2 = find(j, parent);
        parent[p2] = p1;
    }


}