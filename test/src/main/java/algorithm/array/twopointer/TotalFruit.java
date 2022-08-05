package algorithm.array.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午2:08
 */
public class TotalFruit {
    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        System.out.println(totalFruit.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    /**
     * 904 水果成篮
     *
     * @param fruits
     * @return
     */

    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, ans = 0;
        Map<Integer, Integer> cnts = new HashMap<>();
        while (r < fruits.length) {
            cnts.put(fruits[r], cnts.getOrDefault(fruits[r], 0) + 1);
            while (cnts.size() > 2) {
                int cnt = cnts.get(fruits[l]);
                cnt--;
                cnts.put(fruits[l], cnt);
                if (cnt == 0) {
                    cnts.remove(fruits[l]);
                }
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
            ++r;
        }
        return ans;
    }
}
