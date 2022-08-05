package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/23 下午4:14
 */
public class Leetcode_932_beautifulArray {
    public static void main(String[] args) {
        Leetcode_932_beautifulArray l = new Leetcode_932_beautifulArray();
        System.out.println(l.beautifulArray(5));
    }

    Map<Integer, int[]> map;

    public int[] beautifulArray(int n) {
        map = new HashMap<>();
        return f(n);
    }

    private int[] f(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        if (N == 1) {
            return new int[]{1};
        }
        int[] ret = new int[N];
        int i = 0;
        for (int n : f((N + 1) / 2)) {
            ret[i++] = n * 2 - 1;
        }
        for (int n : f(N / 2)) {
            ret[i++] = n * 2;
        }
        map.put(N, ret);
        return ret;
    }

}