package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/15 上午11:11
 */
public class PossiblePartition {

    public static void main(String[] args) {

    }

    public boolean possiblePartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> curSet = aSet;
            Set<Integer> otherSet = bSet;
            if (!aSet.contains(i)) {
                curSet = bSet;
                otherSet = aSet;
            }
            curSet.add(i);
            for (int dislike : map.get(i)) {
                if (curSet.contains(dislike)) {
                    return false;
                }
                otherSet.add(dislike);
            }
        }
        return true;
    }
}
