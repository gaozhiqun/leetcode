package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/1 下午4:10
 */
public class Leetcode_1007_minDominoRotations {

    /**
     * [1,2,1,1,1,2,2,2]
     * [2,1,2,2,2,2,2,2]
     * [-8,3,-5,-3,-5,-2]
     * 6
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_1007_minDominoRotations l = new Leetcode_1007_minDominoRotations();
        System.out.println(l.largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
        System.out.println(l.largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
        System.out.println(l.clumsy(10));
        System.out.println(l.clumsy(4));
        System.out.println(l.minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println(l.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(l.minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));

    }


    public int check(int x, int[] A, int[] B, int n) {
        int ra = 0, rb = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) ra++;
            else if (B[i] != x) rb++;
        }
        return Math.min(ra, rb);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        if (rotations != -1 || A[0] == B[0]) return rotations;
        else return check(B[0], B, A, n);
    }


    public int clumsy(int n) {
        int ret = 0;
        int flag = 1;
        while (n > 0) {
            ret += getGroupNum(n, Math.max(1, n - 3), flag);
            flag = -1;
            n -= 4;
        }
        return ret;
    }

    public int getGroupNum(int max, int min, int flag) {
        if (max == min) {
            return flag * max;
        } else if (max == min + 1) {
            return flag * max * min;
        } else if (max == min + 2) {
            return flag * (min + 3 + 2 / min);
        } else {
            return flag * (min + 4 + 2 / (min + 1)) + min;
        }
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (k > 0) {
            int min = map.firstKey();
            int c = map.get(min);
            if (min >= 0) {
                k %= 2;
                if (k == 0) {
                    break;
                }
            }
            sum -= 2 * min;
            map.put(-min, map.getOrDefault(-min, 0) + 1);
            if (c == 1) {
                map.remove(min);
            } else {
                map.put(min, c - 1);
            }
            --k;
        }
        return sum;
    }


}
