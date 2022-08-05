package algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/2 下午7:32
 */
public class CanPartitionKSubSets {
    public static void main(String[] args) {
        CanPartitionKSubSets canPartitionKSubSets = new CanPartitionKSubSets();
        System.out.println(canPartitionKSubSets.canPartitionKSubSets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    public boolean canPartitionKSubSets(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int sum = 0, average;
        for (int i : nums) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        average = sum / k;
        return bfs(counts, 0, average, 0, k);

    }

    private boolean bfs(Map<Integer, Integer> counts, int accumulate, int average, int cur, int k) {
        if (cur == k) {
            return true;
        }
        if (accumulate > average) {
            return false;
        } else if (accumulate == average) {
            return bfs(counts, 0, average, cur + 1, k);
        } else {
            Set<Integer> nexts = counts.keySet();
            for (int next : nexts) {
                if (counts.get(next) > 0 && accumulate + next <= average) {
                    counts.put(next, counts.get(next) - 1);
                    boolean temp = bfs(counts, accumulate + next, average, cur, k);
                    if (temp) {
                        return true;
                    }
                    counts.put(next, counts.get(next) + 1);
                }
            }
        }
        return false;
    }
}
