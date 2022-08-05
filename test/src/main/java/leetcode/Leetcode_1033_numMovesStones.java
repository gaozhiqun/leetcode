package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/6 下午6:49
 */
public class Leetcode_1033_numMovesStones {
    public static void main(String[] args) {
        Leetcode_1033_numMovesStones l = new Leetcode_1033_numMovesStones();
        System.out.println(l.numMovesStones(3, 5, 1));
        System.out.println(l.numMovesStones(1, 2, 5));
        System.out.println(l.numMovesStones(4, 3, 2));
    }


    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        if (a == b - 1 && a == c - 2) {
            return new int[]{0, 0};
        }
        if (b == a + 1 || c == b + 1 || b == a + 2 || b == c - 2) {
            return new int[]{1, c - a - 2};
        }
        return new int[]{2, c - a - 2};
    }



}
