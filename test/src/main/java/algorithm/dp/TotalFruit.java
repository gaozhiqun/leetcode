package algorithm.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午8:55
 */
public class TotalFruit {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, cnts = 0, ans = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int cur : fruits) {
            cntMap.put(cur, cntMap.getOrDefault(cur, 0) + 1);
            cnts++;
            while (cntMap.size() > 3) {
                int popFruit = fruits[l];
                ++l;
                --cnts;
                int total = cntMap.get(popFruit);
                --total;
                if (total == 0) {
                    cntMap.remove(popFruit);
                } else {
                    cntMap.put(popFruit, total);
                }
            }
            ans = Math.max(ans, cnts);
        }
        return ans;
    }
}
