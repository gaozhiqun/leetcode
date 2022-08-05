package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/16 下午3:17
 */
public class Leetcode_927_threeEqualParts {
    public static void main(String[] args) {
        Leetcode_927_threeEqualParts l = new Leetcode_927_threeEqualParts();
        System.out.println(Arrays.asList(l.threeEqualParts(new int[]{1, 1, 0, 0, 1})));
        System.out.println(Arrays.asList(l.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }

    public int[] threeEqualParts(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 1) {
                pos.add(i);
            }
        }
        int size = pos.size();
        if (size % 3 != 0) {
            return new int[]{-1, -1};
        }
        int m = size / 3;
        int a = pos.get(m - 1), b = pos.get(m), c = pos.get(2 * m - 1), d = pos.get(2 * m);
        for (int i = a; i < b; ++i) {
            for (int j = c; j < d; ++j) {
                int n1 = getNum(arr, 0, i + 1);
                int n2 = getNum(arr, i + 1, j + 1);
                int n3 = getNum(arr, j + 1, arr.length);
                if (n1 == n2 && n2 == n3) {
                    return new int[]{i - 1, j - 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private int getNum(int[] arr, int l, int r) {
        int ret = 0;
        for (int i = l; i < r; ++i) {
            ret = (ret << 1) | arr[i];
        }
        return ret;
    }


}
