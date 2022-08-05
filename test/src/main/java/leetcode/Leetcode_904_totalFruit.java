package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/25 下午2:49
 */
public class Leetcode_904_totalFruit {

    public static void main(String[] args) {
        Leetcode_904_totalFruit l = new Leetcode_904_totalFruit();
        System.out.println(l.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
        System.out.println(l.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(l.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }


    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int l = 0, r = 0, ret = 0;
        while (r < fruits.length) {
            cntMap.put(fruits[r], cntMap.getOrDefault(fruits[r], 0) + 1);
            while (cntMap.size() > 2) {
                int n = fruits[l];
                int cnt = cntMap.get(n) - 1;
                if (cnt == 0) {
                    cntMap.remove(n);
                } else {
                    cntMap.put(n, cnt);
                }
                ++l;
            }
            ret = Math.max(ret, r - l + 1);
            ++r;
        }
        return ret;
    }

}
