package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/26 下午3:36
 */
public class SplitArraySameAverage {


    public static void main(String[] args) {

    }

    public boolean splitArraySameAverage(int[] nums) {
        int m = nums.length;
        if (m % 2 != 0) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[m / 2 + 1][sum / 2 + 1];
        long target = sum / 2;
        //* 0/1背包问题
        return false;
    }
}
