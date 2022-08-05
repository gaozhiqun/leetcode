package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/6 下午5:12
 */
public class Leetcode_352_SummaryRanges {

    public static class SummaryRanges {
        TreeMap<Integer, Integer> treeMap;

        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> pre = treeMap.ceilingEntry(val + 1);
            Map.Entry<Integer, Integer> next = treeMap.floorEntry(val);
            if (next != null && next.getKey() <= val && val <= next.getValue()) {
                // 情况一
                return;
            } else {
                boolean leftAside = next != null && next.getValue() + 1 == val;
                boolean rightAside = pre != null && pre.getKey() - 1 == val;
                if (leftAside && rightAside) {
                    // 情况四
                    int left = next.getKey(), right = pre.getValue();
                    treeMap.remove(next.getKey());
                    treeMap.remove(pre.getKey());
                    treeMap.put(left, right);
                } else if (leftAside) {
                    // 情况二
                    treeMap.put(next.getKey(), next.getValue() + 1);
                } else if (rightAside) {
                    // 情况三
                    int right = pre.getValue();
                    treeMap.remove(pre.getKey());
                    treeMap.put(val, right);
                } else {
                    // 情况五
                    treeMap.put(val, val);
                }
            }

        }

        public int[][] getIntervals() {
            int size = treeMap.size();
            int[][] ans = new int[size][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                int left = entry.getKey(), right = entry.getValue();
                ans[index][0] = left;
                ans[index][1] = right;
                ++index;
            }
            return ans;
        }

    }

    public static void main(String[] args) {

    }


}
