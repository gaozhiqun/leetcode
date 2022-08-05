package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/7 下午9:16
 */
public class TotalFruit {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        return helper(fruits, 2);
    }

    public int helper(int[] fruits, int n) {
        Map<Integer, Integer> counts = new HashMap<>();
        int l = 0, result = 0;
        for (int r = 0; r < fruits.length; r++) {
            counts.put(fruits[r], counts.getOrDefault(fruits[r], 0) + 1);
            while (counts.size() > 2) {
                int newCount = counts.getOrDefault(fruits[l], 0) - 1;
                if (newCount == 0) {
                    counts.remove(fruits[l]);
                }
                l++;
            }
            result = Math.max(r - l + 1, result);
        }
        return result;
    }
}
