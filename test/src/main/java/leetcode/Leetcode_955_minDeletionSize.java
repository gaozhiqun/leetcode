package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/30 下午1:06
 */
public class Leetcode_955_minDeletionSize {
    public static void main(String[] args) {
        Leetcode_955_minDeletionSize l = new Leetcode_955_minDeletionSize();
        System.out.println(l.minDeletionSize(new String[]{"vdy", "vei", "zvc", "zld"}));
        System.out.println(l.minDeletionSize(new String[]{"ca", "bb", "ac"}));
        System.out.println(l.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(l.minDeletionSize(new String[]{"xc", "yb", "za"}));
        //["vdy","vei","zvc","zld"]
    }


    public int minDeletionSize(String[] strs) {
        int N = strs.length;
        int W = strs[0].length();
        boolean[] cuts = new boolean[N-1];

        int ans = 0;
        search: for (int j = 0; j < W; ++j) {
            for (int i = 0; i < N-1; ++i)
                if (!cuts[i] && strs[i].charAt(j) > strs[i+1].charAt(j)) {
                    ans++;
                    continue search;
                }
            for (int i = 0; i < N-1; ++i)
                if (strs[i].charAt(j) < strs[i+1].charAt(j))
                    cuts[i] = true;
        }

        return ans;
    }


}
