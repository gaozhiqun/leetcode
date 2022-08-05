package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_399_findNthDigit {
    public static void main(String[] args) {
        Leetcode_399_findNthDigit l = new Leetcode_399_findNthDigit();

    }

    /**
     * 0*nums[0] + 1*nums[0];
     * 1*nums[0] + 2*nums[1]....+0*nums[n-1];
     * f(i) = f(i-1)+ n*nums[i-1];
     * 15->16->8->4->2->1
     */

    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}



