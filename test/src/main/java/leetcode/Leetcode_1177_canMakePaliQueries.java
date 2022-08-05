package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/5 下午3:15
 */
public class Leetcode_1177_canMakePaliQueries {
    public static void main(String[] args) {
        Leetcode_1177_canMakePaliQueries l = new Leetcode_1177_canMakePaliQueries();
        int[][] queries = new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        System.out.println(l.canMakePaliQueries("abcda", queries));

    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int length = s.length();
        int[] arr = new int[length + 1];
        for (int i = 0; i < length; i++) {
            arr[i + 1] = arr[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> list = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int v = arr[query[1] + 1] ^ arr[query[0]];
            int c = 0;
            while (v != 0) {
                c++;
                v = v & (v - 1);
            }
            list.add(c <= (query[2] << 1) + 1);
        }
        return list;
    }

}
