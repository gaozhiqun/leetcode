package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_335_isSelfCrossing {
    public static void main(String[] args) {
        Leetcode_335_isSelfCrossing l = new Leetcode_335_isSelfCrossing();

    }


    /**
     * int [] line 0, x, y1, y2
     * int [] line 1, y, x1, x2
     *
     * @param distance
     * @return
     */

    int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        for (int i = 3; i < n; ++i) {
            // 第 1 类路径交叉的情况
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // 第 2 类路径交叉的情况
            if (i == 4 && (distance[3] == distance[1]
                    && distance[4] >= distance[2] - distance[0])) {
                return true;
            }

            // 第 3 类路径交叉的情况
            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 2] > distance[i - 4])) {
                return true;
            }
        }
        return false;
    }
}

