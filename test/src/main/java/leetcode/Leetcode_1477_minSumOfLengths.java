package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/1 下午1:50
 */
public class Leetcode_1477_minSumOfLengths {

    public static void main(String[] args) {
        Leetcode_1477_minSumOfLengths l = new Leetcode_1477_minSumOfLengths();
        System.out.println(l.minSumOfLengths(new int[]{1, 1, 1, 2, 2, 2, 4, 4}, 6));
        System.out.println(l.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
    }


    public int minSumOfLengths(int[] arr, int target) {
        int l1 = -1, r1 = 0, sum = 0;
        int ret = Integer.MAX_VALUE;
        while (r1 < arr.length) {
            sum += arr[r1];
            while (sum >= target) {
                if (sum == target) {
                    int l2 = r1, r2 = r1 + 1, sum2 = 0;
                    while (r2 < arr.length) {
                        sum2 += arr[r2];
                        while (sum2 >= target) {
                            if (sum2 == target) {
                                ret = Math.min(ret, r1 - l1 + r2 - l2);
                            }
                            sum2 -= arr[++l2];
                        }
                        ++r2;
                    }

                }
                sum -= arr[++l1];
            }
            ++r1;
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }


}
