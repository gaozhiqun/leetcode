package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_828_uniqueLetterString {

    public static void main(String[] args) {
        Leetcode_828_uniqueLetterString l = new Leetcode_828_uniqueLetterString();
        System.out.println(l.uniqueLetterString("ABC"));
        System.out.println(l.uniqueLetterString("ABA"));
        System.out.println(l.uniqueLetterString("LEETCODE"));
//        System.out.println(l.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }

    /**
     * 分别统计每个字符组成的字符串
     * @param s
     * @return
     */

    public int uniqueLetterString(String s) {
        List<Integer>[] posList = new List[26];
        int N = s.length();
        long ret = 0, mod = 1000_000_007;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (posList[ch - 'A'] == null) {
                posList[ch - 'A'] = new ArrayList<>();
            }
            posList[ch - 'A'].add(i);
        }
        for (int i = 0; i < posList.length; ++i) {
            if (posList[i] == null) {
                continue;
            }
            for (int j = 0; j < posList[i].size(); ++j) {
                int pos = posList[i].get(j);
                int pre = j == 0 ? -1 : posList[i].get(j - 1);
                int next = j == posList[i].size() - 1 ? N : posList[i].get(j + 1);
                ret += (pos - pre) * (next - pos);
            }
        }
        return (int) (ret % mod);
    }


}