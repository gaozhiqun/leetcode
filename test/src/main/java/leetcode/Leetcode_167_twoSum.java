package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_167_twoSum {

    public static void main(String[] args) {
        Leetcode_167_twoSum l = new Leetcode_167_twoSum();
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }
}