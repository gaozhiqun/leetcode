package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_280_addOperator {
    public static void main(String[] args) {
        Leetcode_280_addOperator l = new Leetcode_280_addOperator();
        int[] array = new int[]{0, 1, 0, 3, 12};
        l.moveZeroes(array);
        System.out.println(Arrays.asList(array));
        System.out.println(l.addOperators("00", 0));
        System.out.println(l.addOperators("3456237490", 9191));
        System.out.println(l.addOperators("123", 6));
        System.out.println(l.addOperators("105", 5));
        System.out.println(l.addOperators("232", 8));

    }

    private int m, target;
    private List<String> ans;
    private String num;

    public List<String> addOperators(String num, int target) {
        m = num.length();
        this.target = target;
        this.num = num;
        this.ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, 0);
        return ans;

    }

    private void backtrack(StringBuilder s, int i, long res, long mul) {
        if (i == m) {
            if (res == target) {
                ans.add(s.toString());
            }
            return;
        }
        int len = s.length();
        if (i > 0) {
            s.append("0");
        }
        long val = 0;
        for (int j = i; j < m && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            s.append(num.charAt(j));
            if (i == 0) { // 表达式开头不能添加符号
                backtrack(s, j + 1, val, val);
            } else { // 枚举符号
                s.setCharAt(len, '+');
                backtrack(s, j + 1, res + val, val);
                s.setCharAt(len, '-');
                backtrack(s, j + 1, res - val, -val);
                s.setCharAt(len, '*');
                backtrack(s, j + 1, res - mul + mul * val, mul * val);
            }
        }
        s.setLength(len);
    }


    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
            ++j;
        }
        Arrays.fill(nums, i, nums.length, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
