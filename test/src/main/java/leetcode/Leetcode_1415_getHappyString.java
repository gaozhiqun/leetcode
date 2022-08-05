package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/23 下午5:56
 */
public class Leetcode_1415_getHappyString {
    public static void main(String[] args) {
        Leetcode_1415_getHappyString l = new Leetcode_1415_getHappyString();
        //    System.out.println(l.getHappyString(3, 9));
        System.out.println(l.getHappyString(10, 100));
    }

    /**
     * 3 * 2 * 2 * 2
     * <p>
     * 3*2    abcabcabcabc
     *
     * @param n
     * @param k
     * @return
     */


    public String getHappyString(int n, int k) {
        int count = 3 << (n - 1);
        if (k > count) {
            return "";
        }
        char[] result = new char[n];
        int[][] stateTab = new int[][]{{1, 2}, {0, 2}, {0, 1}};
        int order = k - 1;
        int index = 0, state = order >> (n - 1);
        result[index++] = (char) (state + 'a');
        int tree = order & ((1 << (n - 1)) - 1);
        for (int i = n - 2; i >= 0; i--) {
            state = stateTab[state][(tree >> i) & 1];
            result[index++] = (char) (state + 'a');
        }
        return String.valueOf(result);
    }

    
}
