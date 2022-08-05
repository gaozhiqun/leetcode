package algorithm.array;

import algorithm.UnionFind;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/14 下午8:38
 */
public class MinSwapsCouples {
    public static void main(String[] args) {
        MinSwapsCouples minSwapsCouples = new MinSwapsCouples();
//        System.out.println(minSwapsCouples.minSwapCouples(new int[]{3, 2, 0, 1}));
        System.out.println(minSwapsCouples.minSwapCouples(new int[]{0, 2, 1, 3}));
    }

    public int minSwapCouples(int[] row) {
        int[] p = new int[row.length / 2];
        int[] cnt = new int[row.length / 2];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        Arrays.fill(cnt, 1);
        for (int i = 0; i < row.length / 2; ++i) {
            union(row[i * 2] / 2, row[i * 2 + 1] / 2, p, cnt);
        }
        int result = 0;
        for (int i = 0; i < row.length / 2; i++) {
            if (find(p, i) == i) {
                result += cnt[i] - 1;
            }
        }
        return result;
    }

    private void union(int i, int j, int[] p, int[] cnt) {
        int p1 = find(p, i);
        int p2 = find(p, j);
        if (p1 == p2) {
            return;
        }
        if (cnt[p1] <= cnt[p2]) {
            cnt[p2] += cnt[p1];
            p[p1] = p2;
        } else {
            cnt[p1] += cnt[p2];
            p[p2] = p1;
        }
    }

    private int find(int[] p, int i) {
        while (i != p[i]) {
            i = p[i];
        }
        return i;
    }

}
