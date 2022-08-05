package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_842_splitIntoFibonacci {
    public static void main(String[] args) {
        Leetcode_842_splitIntoFibonacci l = new Leetcode_842_splitIntoFibonacci();
        System.out.println(l.splitIntoFibonacci("11235813"));
        System.out.println(l.splitIntoFibonacci("112358130"));
        System.out.println(l.splitIntoFibonacci("0123"));
//        System.out.println(l.numMagicSquaresInside(new int[][]{
//                {4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}
//        }));
    }


    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, num, num.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String num, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + num.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, num, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }


}
