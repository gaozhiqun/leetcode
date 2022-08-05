package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_501_IPO {

    public static void main(String[] args) {
        Leetcode_501_IPO l = new Leetcode_501_IPO();
        System.out.println(l.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(l.nextGreaterElements(new int[]{1, 2, 1}));
    }

    /**
     * k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
     * k 个不同的项目
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> projects = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> available = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < profits.length; i++) {
            projects.offer(new int[]{capital[i], profits[i]});
        }
        while (k > 0) {
            --k;
            while (!projects.isEmpty() && projects.peek()[0] <= w) {
                available.offer(projects.poll());
            }
            if (available.isEmpty()) {
                break;
            } else {
                w += available.poll()[1];
            }
        }
        return w;
    }


    public int[] nextGreaterElements(int[] nums) {
        int m = nums.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < 2 * m; i++) {
            int next = i % m;
            while (!minStack.empty() && nums[minStack.peek()] < nums[next]) {
                ans[minStack.pop() % m] = nums[next];
            }
            minStack.push(next);
        }
        return ans;
    }


}
