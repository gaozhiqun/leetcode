package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/9 下午2:26
 */
public class Leetcode_1072_maxEqualRowsAfterFlips {
    public static void main(String[] args) {

    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] x : matrix) {
            String a = "";
            String b = "";
            for (int y : x) {
                a += y;
                b += (1 ^ y);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
            res = Math.max(res, Math.max(map.get(a), map.get(b)));
        }
        return res;
    }


    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int len = Math.max(i + 1, j + 1) + 2;
        int[] res = new int[len];
        int c = 0, k = len - 1;
        while (i >= 0 || j >= 0 || c != 0) {
            if (i >= 0) {
                c += arr1[i];
            }
            if (j >= 0) {
                c += arr2[j];
            }
            res[k--] = Math.abs(c) % 2;
            if (c < 0) {
                c = 1;
            } else if (c > 1) {
                c = -1;
            } else {
                c = 0;
            }
            i--;
            j--;
        }
        int index = 0;
        while (index < len - 1 && res[index] == 0) {
            index++;
        }
        return Arrays.copyOfRange(res, index, len);
    }

}
