package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/28 下午7:11
 */
public class Leetcode_967_numsSameConsecDiff {
    public static void main(String[] args) {
        Leetcode_967_numsSameConsecDiff l = new Leetcode_967_numsSameConsecDiff();
        System.out.println(l.numsSameConsecDiff(3, 7));
        System.out.println(l.numsSameConsecDiff(2, 1));
    }

    /**
     * 长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数
     * 181,292,707,818,929
     *
     * @param n
     * @param k
     * @return
     */
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int len = 2; len <= n; ++len) {
            Set<Integer> temp = new HashSet<>();
            for (int i : list) {
                int r = i % 10;
                if (r + k < 10) {
                    temp.add(i * 10 + r + k);
                }
                if (r - k >= 0) {
                    temp.add(i * 10 + r - k);
                }
            }
            list = new ArrayList<>(temp);
        }
        System.out.println(list);
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = i;
        }
        return ret;
    }

}
