package algorithm.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/29 7:02 下午
 */
public class MaxmiumReactAngle {
    public static void main(String[] args) {

    }

    public int maximumValue(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            result = Math.max(result, helper(array, i));
        }
        return result;
    }

    private int helper(int[] array, int cur) {
        int i = cur, j = cur;
        while (i > -1 && array[i] >= cur) {
            i--;
        }
        while (j < array.length && array[j] <= cur) {
            j++;
        }
        return (j - i + 1) * array[cur];
    }

    //最大的矩形
    //单调栈
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> monoStack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            //单调递增栈，找到右侧第一个比自己小的
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                right[monoStack.peek()] = i;
                monoStack.pop();
            }
            left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public int largestRectangleArea(int[][] area) {
        for (int i = 1; i < area.length; i++) {
            for (int j = 0; i < area[0].length; j++) {
                if (area[i][j] == 1) {
                    area[i][j] += area[i - 1][j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < area.length; i++) {
            result = Math.max(result, largestRectangleArea(area[i]));
        }
        return result;
    }




}
