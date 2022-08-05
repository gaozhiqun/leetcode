package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_685_findRedundantConnection {

    public static void main(String[] args) {
        Leetcode_685_findRedundantConnection l = new Leetcode_685_findRedundantConnection();
        System.out.println(l.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}));
        System.out.println(l.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}}));
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] union = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
            union[i] = i;
        }
        int conflict = -1, cycle = -1;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {//已经有别的点指向该点
                conflict = i;
            } else {
                parent[node2] = node1;
                if (find(node1, union) == find(node2, union)) {
                    cycle = i; //指向根结点
                } else {
                    union(node1, node2, union);
                }
            }
        }
        if (conflict < 0) {
            return new int[]{edges[cycle][0], edges[cycle][1]}; //无冲突，但是有循环，返回循环节点
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            } else {
                return new int[]{conflictEdge[0], conflictEdge[1]}; //附加边指向根结点
            }
        }
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