package leetcode;


import algorithm.array.MinIncresementForUnique;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_587_outerTrees {

    /**
     * 方法 2：Graham 扫描 [Accepted]
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_587_outerTrees leetcode_560_subarraySum = new Leetcode_587_outerTrees();
    }

    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1) {
            return trees;
        }
        int[] bm = bottomLeft(trees);
        Arrays.sort(trees, (t1, t2) -> {
            int diff = orientation(bm, t1, t2) - orientation(bm, t2, t1);
            if (diff == 0) {
                diff = distance(bm, t1) - distance(bm, t2);
            }
            return diff > 0 ? 1 : -1;
        });
        int i = trees.length - 1;
        while (i >= 0 && orientation(bm, trees[trees.length - 1], trees[i]) == 0) {
            i--;
        }
        for (int l = i + 1, r = trees.length - 1; l < r; l++, r--) {
            int[] temp = trees[l];
            trees[l] = trees[r];
            trees[r] = temp;
        }
        Stack<int[]> stack = new Stack<>();
        stack.push(trees[0]);
        stack.push(trees[1]);
        for (int j = 2; j < trees.length; j++) {
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, trees[j]) > 0) {
                top = stack.pop();
            }
            stack.push(trees[j]);
        }
        int[][] res = new int[stack.size()][2];
        int index = 0;
        for (int[] tree : stack) {
            res[index] = tree;
            index++;
        }
        return res;
    }

    //找凸壳，如果>0说明是右转，否则左转，抛弃q
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    public int[] bottomLeft(int[][] trees) {
        int[] p = trees[0];
        for (int i = 0; i < trees.length; i++) {
            if (trees[i][1] < p[1]) {
                p = trees[i];
            }
        }
        return p;
    }
}