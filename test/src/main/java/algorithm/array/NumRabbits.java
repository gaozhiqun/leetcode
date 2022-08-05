package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 下午4:54
 */
public class NumRabbits {
    public static void main(String[] args) {
        NumRabbits numRabbits = new NumRabbits();
        System.out.println(numRabbits.numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits.numRabbits(new int[]{10, 10, 10}));
    }

    public int numRabbits(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : nums) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int n = entry.getKey();
            int m = entry.getValue();
            while (m > 0) {
                total += (n + 1);
                m -= n + 1;//最多n只兔子说毛色一样
            }
        }
        return total;
    }
}
