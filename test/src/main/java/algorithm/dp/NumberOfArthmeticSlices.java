package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/17 下午8:56
 */
public class NumberOfArthmeticSlices {

    public static void main(String[] args) {

    }

    public int numberOfArtithmeticSlices(int[] nums) {
        int gap = 0;
        int length = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (gap != nums[i] - nums[i - 1]) {
                gap = nums[i] - nums[i - 1];
                result += total(length);
                length = 2;
            } else {
                length++;
            }
            if (i == nums.length - 1) {
                result += total(length);
            }
        }
        return result;
    }

    public int total(int length) {
        int total = 0;
        for (int i = 2; i < length; i++) {
            total += length - i;
        }
        return total;
    }
}
