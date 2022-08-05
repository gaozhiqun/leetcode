package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/5/5 下午6:02
 */
public class Leetcode_1053_prevPermOpt1 {
    public static void main(String[] args) {
        Leetcode_1053_prevPermOpt1 l = new Leetcode_1053_prevPermOpt1();
    }

    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                for (int j = i + 1; j < len; j++) {
                    if (A[i] > A[j]) {
                        hasResult = true;
                        if (A[j] > curMax) {
                            curMax = A[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index] = tmp;
                    return A;
                }
            }
        }
        return A;
    }


}
