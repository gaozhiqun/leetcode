package leetcode;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_24Game {



    public boolean judgePoint24(int[] nums) {
        return backTrack(nums, 0);
    }


    public boolean backTrack(int[] nums, int index) {
        if (index == 3) {
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int i = index; i < 4; i++) {
            swap(nums, index, i);
            if (backTrack(nums, index + 1)) {
                return true;
            }
            swap(nums, index, i);
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public boolean judge(double a, double b, double c, double d) {
        return judge(a + b, c, d) ||
                judge(a - b, c, d) ||
                judge(a * b, c, d) ||
                judge(a / b, c, d);
    }

    public boolean judge(double a, double b, double c) {
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b - a, c) ||
                judge(b / a, c) ||
                judge(a, b + c) ||
                judge(a, b - c) ||
                judge(a, b * c) ||
                judge(a, b / c);
    }

    public boolean judge(double a, double b) {
        return Math.abs(a + b - 24) < 0.001 ||
                Math.abs(a - b - 24) < 0.001 ||
                Math.abs(a * b - 24) < 0.001 ||
                Math.abs(a / b - 24) < 0.001 ||
                Math.abs(b - a - 24) < 0.001 ||
                Math.abs(b / a - 24) < 0.001;
    }


}