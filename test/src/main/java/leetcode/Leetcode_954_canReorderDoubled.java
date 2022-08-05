package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/25 下午2:36
 */
public class Leetcode_954_canReorderDoubled {
    public static void main(String[] args) {
        Leetcode_954_canReorderDoubled l = new Leetcode_954_canReorderDoubled();
        System.out.println(l.canReorderDoubled(new int[]{2, -2, 4, -4}));

    }


    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : arr) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(cnts.keySet());
        Collections.sort(keys, Comparator.comparingInt(Math::abs));
        for (int i = 0; i < keys.size(); ++i) {
            int s = keys.get(i);
            int sc = cnts.get(s);
            if (sc == 0) {
                continue;
            }
            int b = 2 * s;
            int bc = cnts.getOrDefault(b, 0);
            if (bc < sc) {
                return false;
            }
            cnts.put(b, bc - sc);
        }
        return true;
    }


}
