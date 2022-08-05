package algorithm.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/22 6:19 下午
 */
public class NumSums {
    public static void main(String[] args) {

        NumSums numSums = new NumSums();
        System.out.println(numSums.bottomWithMaxiumWater(new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        }));
    }


    private List<List<Integer>> fourNumSums(int[][] array) {
        //1 merge Array 并排序
        //2 2分查找
        return null;
    }


    public int bottomWithMaxiumWater(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int result = Integer.MIN_VALUE;
        while (i < j) {
            result = Math.max(result, (j - i) * Math.min(array[i], array[j]));
            if (array[i] < array[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }


    public int getKthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;
        while (true) {
            if (i == m) {
                return b[j + k - 1];
            }
            if (j == n) {
                return a[i + k - 1];
            }
            if (k == 1) {
                return Math.min(a[i], b[j]);
            }
            int half = k / 2;
            int newI = Math.min(i + half, m) - 1;
            int newJ = Math.min(j + half, m) - 1;
            int p1 = a[i], p2 = a[j];
            if (p1 < p2) {
                k -= (newI - i + 1);
                i = newI + 1;
            } else {
                k -= (newJ - j + 1);
                j = newJ + 1;
            }

        }

    }



}
