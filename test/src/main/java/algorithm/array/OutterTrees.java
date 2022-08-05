package algorithm.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 下午8:29
 */
public class OutterTrees {

    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1) {
            return trees;
        }
        int[] bm = bottomLeft(trees);
        Arrays.sort(trees, (o1, o2) -> {
            double diff = orientation(bm, o1, o2) - orientation(bm, o2, o1);
            if (diff == 0) {
                return distance(bm, o1) - distance(bm, o2);
            } else {
                return diff > 0 ? 1 : -1;
            }
        });

        int i = trees.length - 1;
        while (i >= 0 && orientation(bm, trees[trees.length - 1], trees[i]) == 0) {
            i--;
        }
        for (int l = i + 1, h = trees.length - 1; l < h; l++, h--) {
            int[] temp = trees[l];
            trees[l] = trees[h];
            trees[h] = temp;
        }
        //共线最远点倒序找到最后一条线最远的点
        Stack<int[]> stack = new Stack<>();
        stack.push(trees[0]);
        stack.push(trees[1]);
        for (int j = 2; j < trees.length; j++) {
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, trees[j]) > 0) {
                top = stack.pop();//内凹，舍弃
            }
            stack.push(top);
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

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private int[] bottomLeft(int[][] points) {
        int[] bottomLeft = points[0];
        for (int[] p : points) {
            if (p[1] < bottomLeft[1]) {
                bottomLeft = p;
            }
        }
        return bottomLeft;
    }



}
