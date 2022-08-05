package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/4 上午11:13
 */
public class Leetcode_923_threeSumMulti {
    public static void main(String[] args) {
        Leetcode_923_threeSumMulti l = new Leetcode_923_threeSumMulti();
        System.out.println(l.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }

    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            int n = arr[i];
            List<Integer> list = map.computeIfAbsent(n, f -> new ArrayList<>());
            list.add(i);
        }
        int ret = 0, MOD = 1_000_000_007;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                List<Integer> list = map.get(target - arr[i] - arr[j]);
                if (Objects.nonNull(list)) {
                    ret += greater(list, j);
                    ret %= MOD;
                }
            }
        }
        return ret;
    }

    public int greater(List<Integer> list, int n) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) <= n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.size() - l + 1;
    }


}
