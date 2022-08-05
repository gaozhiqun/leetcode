package algorithm.niuke;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/21 下午3:12
 */
public class CombineSum {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (num == null || num.length == 0 || target < 0) return res;
        Arrays.sort(num);//对候选数组进行排序 方便后续处理
        dfs(num, target, res, arr, 0);
        return res;
    }

    void dfs(int[] num, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int start) {
        if (target == 0) {
            //已找到一组 存储进res
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if (start >= num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            //回溯操作
            if (num[i] <= target) {
                arr.add(num[i]);
                dfs(num, target - num[i], res, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        while ((line = scanner.nextLine()) != null) {
            System.out.println();
        }
        int[] digits = new int[]{100, 10, 20, 70, 60, 10, 50};
        CombineSum combineSum = new CombineSum();
        System.out.println(combineSum.longestValidParentheses("(())((()))((()"));
        System.out.println(combineSum.longestValidParentheses("(())"));
        System.out.println(combineSum.longestValidParentheses("()(())()"));
        System.out.println(combineSum.combinationSum2(digits, 80));
    }


    public int longestValidParentheses(String s) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int m = s.length();
        int[] dp = new int[m + 1];
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int match = stack.pop();
                    dp[i + 1] = (i - match + 1) + dp[match];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();


    }

}

