package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/29 下午3:56
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }

    TreeMap<Integer, int[]> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        int[] target = treeMap.get(val);

    }

    public int[][] getIntervals() {
        int[][] result = new int[treeMap.size()][2];
        return result;
    }
}
