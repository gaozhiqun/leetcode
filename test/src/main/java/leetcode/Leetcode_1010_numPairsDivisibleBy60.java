package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/1 上午11:00
 */
public class Leetcode_1010_numPairsDivisibleBy60 {
    public static void main(String[] args) {
        Leetcode_1010_numPairsDivisibleBy60 l = new Leetcode_1010_numPairsDivisibleBy60();
        System.out.println(l.numPairsDivisibleBy60(new int[]{60, 60, 60}));

    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int i : time) {
            int r = i % 60;
            ret += cnt.getOrDefault((60 - r) % 60, 0);
            cnt.put(r, cnt.getOrDefault(r, 0) + 1);
        }
        return ret;
    }
}
