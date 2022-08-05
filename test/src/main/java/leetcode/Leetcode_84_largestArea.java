package leetcode;



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_84_largestArea {

    public static void main(String[] args) {
        Leetcode_84_largestArea l = new Leetcode_84_largestArea();
        System.out.println(l.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(l.largestRectangleArea2(new int[]{2, 4}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        return calculateArea(0, heights.length - 1, heights);
    }

    private int calculateArea(int l, int r, int[] heights) {
        if (r < l) {
            return 0;
        } else if (l == r) {
            return heights[l];
        }
        int pos = l;
        for (int i = l; i <= r; i++) {
            if (heights[pos] > heights[i]) {
                pos = i;
            }
        }
        int ans = heights[pos] * (r - l + 1);
        ans = Math.max(ans, Math.max(calculateArea(l, pos - 1, heights),
                calculateArea(pos + 1, r, heights)));
        return ans;
    }

    /**
     * 单调递增栈
     *
     * @return
     */
    private int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int m = heights.length;
        int[] preSmaller = new int[m], nextSmaller = new int[m];
        Arrays.fill(preSmaller, -1);
        Arrays.fill(nextSmaller, m);
        Deque<Integer> incrStack = new ArrayDeque<Integer>();
        for (int i = 0; i < m; ++i) {
            int j = m - 1 - i;
            while (!incrStack.isEmpty() && heights[incrStack.peek()] > heights[i]) {
                nextSmaller[incrStack.pop()] = i;
            }
            preSmaller[i] = (incrStack.isEmpty() ? -1 : incrStack.peek());
            incrStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            ans = Math.max(ans, (nextSmaller[i] - preSmaller[i] - 1) * heights[i]);
        }
        return ans;
    }
}
