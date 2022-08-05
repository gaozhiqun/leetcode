package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_246_isStrobogrammatic {
    public static void main(String[] args) {
        Leetcode_246_isStrobogrammatic l = new Leetcode_246_isStrobogrammatic();

    }

    public boolean isStrobogrammatic(String num) {
        int[] mapping = new int[10];
        Arrays.fill(mapping, -1);
        mapping[0] = 0;
        mapping[1] = 1;
        mapping[8] = 8;
        mapping[6] = 9;
        mapping[9] = 6;
        int l = 0, r = num.length() - 1;
        while (l < r) {
            if (mapping[num.charAt(l) - '0'] != num.charAt(r) - '0') {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

}
