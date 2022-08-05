package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_761_makeLargestSpecial {
    public static void main(String[] args) {
        Leetcode_761_makeLargestSpecial l = new Leetcode_761_makeLargestSpecial();
        System.out.println(l.makeLargestSpecial("11011000"));
    }

    /**
     * Draw a line from (x, y) to (x+1, y+1) if we see a "1",
     * else to (x+1, y-1). A special substring is just a line that starts and ends at the same y-coordinate,
     * and that is the lowest y-coordinate reached.
     * Call a mountain a special substring with no special prefixes - ie.
     * only at the beginning and end is the lowest y-coordinate reached.
     * If F is the answer function, and S has mountain decomposition M1,M2,M3,...,Mk,
     * then the answer is: reverse_sorted(F(M1), F(M2), ..., F(Mk)).
     * However, you'll also need to deal with the case that S is a mountain, such as 11011000 -> 11100100.
     *
     * @param s
     * @return
     */


    public String makeLargestSpecial(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0, pre = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            cnt += S.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                list.add("1" + makeLargestSpecial(S.substring(pre + 1, i)) + "0");
                pre = i + 1;
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; --i) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }


}
