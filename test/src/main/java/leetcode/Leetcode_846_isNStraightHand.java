package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_846_isNStraightHand {
    public static void main(String[] args) {
        Leetcode_846_isNStraightHand l = new Leetcode_846_isNStraightHand();
        System.out.println(l.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(l.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();
        for (int i : hand) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        while (!cnts.isEmpty()) {
            int min = cnts.firstKey();
            for (int i = 0; i < groupSize; ++i) {
                int cnt = cnts.getOrDefault(min + i, 0);
                if (cnt <= 0) {
                    return false;
                }
                --cnt;
                if (cnt == 0) {
                    cnts.remove(min + i);
                } else {
                    cnts.put(min + i, cnt);
                }
            }
        }
        return true;
    }

    public int longestMountain(int[] arr) {
        int ret = 0;
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int l = i, r = i;
                while (l > 0 && arr[l] > arr[l - 1]) {
                    --l;
                }
                while (r < arr.length - 1 && arr[r] > arr[r + 1]) {
                    ++r;
                }
                ret = Math.max(r - l + 1, ret);
            }
        }
        return ret;
    }

    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }

    private String process(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

}
