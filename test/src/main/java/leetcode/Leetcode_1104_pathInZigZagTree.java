package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午12:11
 */
public class Leetcode_1104_pathInZigZagTree {
    public static void main(String[] args) {
        Leetcode_1104_pathInZigZagTree l = new Leetcode_1104_pathInZigZagTree();

        System.out.println(l.pathInZigZagTree(14));
        System.out.println(l.pathInZigZagTree(26));
    }


    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row));
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    public int getReverse(int label, int row) {
        return (1 << row - 1) + (1 << row) - 1 - label;
    }


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefixSum = new int[n + 1];
        int[] ret = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1];
            int val = booking[2];
            prefixSum[i] += val;
            prefixSum[j] -= val;
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += prefixSum[i];
            ret[i] = sum;
        }
        return ret;
    }
}
