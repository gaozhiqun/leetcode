package algorithm.dp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/5 下午4:07
 */
public class MinMutation {
    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        System.out.println(minMutation.minMutation("AACCGGTT", "AAACGGTA", new String[]{
                "AACCGGTA", "AACCGCTA", "AAACGGTA"
        }));
    }


    public int minMutation(String start, String end, String[] bank) {
        Set<String> used = new HashSet<>();
        return minMutation(start, end, used, bank);
    }

    public int minMutation(String cur, String target, Set<String> used, String[] bank) {
        if (cur.equals(target)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String next : bank) {
            if (!used.contains(next) && canMutate(cur, next)) {
                used.add(next);
                int nextMin = minMutation(next, target, used, bank);
                min = Math.min(min, nextMin == Integer.MAX_VALUE ? nextMin : nextMin + 1);
                used.remove(next);
            }
        }
        return min;
    }

    private boolean canMutate(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
