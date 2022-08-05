package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/12 上午10:26
 */
public class Leetcode_782_movesToChessboard {

    public static void main(String[] args) {
        Leetcode_782_movesToChessboard l = new Leetcode_782_movesToChessboard();
    }

    /**
     * 行列数的范围是[2, 30]。
     *
     * @param board
     * @return 1 0 1 0 1 0 1 0 1 0
     * 0 1 0 1 0 1 0 1 0 1
     */


    private int getNum(int[] line) {
        int digit = 0, n = line.length;
        for (int i = 0; i < n; i++) {
            if (line[i] == 1) {
                digit |= (line[i] << (n - i - 1));
            }
        }
        return digit;
    }

    public int numRabbits(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> cntsMap = new HashMap<>();
        for (int i : answers) {
            cntsMap.put(i, cntsMap.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cntsMap.entrySet()) {
            int m = entry.getKey();
            int cnt = entry.getValue();
            ans += (cnt % (m + 1) == 0) ? cnt : (cnt / (m + 1) + 1) * (m + 1);
        }
        return ans;
    }


}

