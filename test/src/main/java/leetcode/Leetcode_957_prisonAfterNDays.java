package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/25 下午7:08
 */
public class Leetcode_957_prisonAfterNDays {
    public static void main(String[] args) {
        Leetcode_957_prisonAfterNDays l = new Leetcode_957_prisonAfterNDays();
        int[] ret = l.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7);
        System.out.println(Arrays.asList(ret));

        ret = l.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000);
        System.out.println(Arrays.asList(ret));
    }

    /***
     * cells.length == 8
     * cells[i] 的值为 0 或 1
     * 1 <= N <= 10^9
     */
    Map<Integer, Integer> statusMap;

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (n == 0) {
            return cells;
        }
        statusMap = new HashMap<>();
        int init = getStatus(cells);
        int status = init;
        while (n > 0) {
            if (statusMap.containsKey(status)) {
                n %= statusMap.get(status) - n;
                //找到第一个循环节，有些状态再也回不去
            }
            statusMap.put(status, n);
            if (n >= 1) {
                n--;
                status = getNext(status);
            }
        }
        return getArray(status);
    }


    private int[] getArray(int cur) {
        int[] cells = new int[8];
        for (int i = 0; i < 8; ++i) {
            cells[i] = 1 & (cur >>> i);
        }
        return cells;
    }

    private int getNext(int cur) {
        int[] cells = getArray(cur);
        int[] next = new int[8];
        for (int i = 1; i < 7; ++i) {
            next[i] = cells[i - 1] ^ cells[i + 1] ^ 1;
        }
        return getStatus(next);
    }

    private int getStatus(int[] status) {
        int ret = 0;
        for (int i = 0; i < 8; ++i) {
            ret |= status[i] << i;
        }
        return ret;
    }


}
