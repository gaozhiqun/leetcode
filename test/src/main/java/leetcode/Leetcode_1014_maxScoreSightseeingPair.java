package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/2 下午5:23
 */
public class Leetcode_1014_maxScoreSightseeingPair {
    public static void main(String[] args) {
        Leetcode_1014_maxScoreSightseeingPair l = new Leetcode_1014_maxScoreSightseeingPair();
        System.out.println(l.canThreePartsEqualSum(new int[]{
                0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1
        }));

        System.out.println(l.canThreePartsEqualSum(new int[]{
                0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1
        }));

        System.out.println(l.canThreePartsEqualSum(new int[]{
                3, 3, 6, 5, -2, 2, 5, 1, -9, 4
        }));

        System.out.println(l.canThreePartsEqualSum(new int[]{
                6, 1, 1, 13, -1, 0, -10, 20
        }));

        System.out.println(l.maxScoreSightseeingPair(new int[]{
                8, 1, 5, 2, 6
        }));
    }

    /**
     * values[i] + values[j] + i - j
     *
     * @param values
     * @return
     */

    public int maxScoreSightseeingPair(int[] values) {
        int N = values.length;
        int[] score = new int[N];
        for (int i = 0; i < values.length; ++i) {
            score[i] = values[i] + i;
        }
        int ret = 0;
        int max = score[0];
        for (int i = 1; i < values.length; ++i) {
            ret = Math.max(ret, max + values[i] - i);
            max = Math.max(max, score[i]);
        }
        return ret;
    }


    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }
        return partition(arr, 0, arr.length, 3, sum / 3);

    }

    public boolean partition(int[] arr, int l, int r, int k, int target) {
        if (l == r && k == 0) {
            return true;
        }
        boolean ret = false;
        int sum = 0;
        for (int i = l; i < r; ++i) {
            sum += arr[i];
            if (sum == target) {
                ret |= partition(arr, i + 1, r, k - 1, target);
            }
        }
        return ret;
    }


}
