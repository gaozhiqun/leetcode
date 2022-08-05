package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/6 下午2:57
 */
public class Leetcode_593_validSqure {
    public static void main(String[] args) {

    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, Integer> cnts = new HashMap<>();
        int[] num = new int[6];
        num[1] = distance(p1, p2);
        num[2] = distance(p1, p3);
        num[3] = distance(p1, p4);
        num[4] = distance(p2, p3);
        num[5] = distance(p2, p4);
        num[0] = distance(p3, p4);
        Arrays.sort(num);
        return num[0] * num[0] * 2 == num[5] * num[5];


    }

    private int distance(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }
}
