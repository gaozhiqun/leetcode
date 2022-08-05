package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/28 下午7:18
 */
public class Leetcode_908_smallestRangeI {
    public static void main(String[] args) {
        Leetcode_908_smallestRangeI l = new Leetcode_908_smallestRangeI();
        System.out.println(l.smallestRangeI(new int[]{1, 3, 6}, 3));

    }

    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return Math.max(0, max - min - 2 * k);
    }
}
