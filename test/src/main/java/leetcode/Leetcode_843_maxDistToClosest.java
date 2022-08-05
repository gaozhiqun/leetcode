package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/27 下午2:48
 */
public class Leetcode_843_maxDistToClosest {
    public static void main(String[] args) {
        Leetcode_843_maxDistToClosest l = new Leetcode_843_maxDistToClosest();
        System.out.println(l.shiftingLetters("abc", new int[]{3, 5, 9}));
        System.out.println(l.maxDistToClosest(new int[]{
                1, 0, 0, 0, 1, 0, 1
        }));
        System.out.println(l.maxDistToClosest(new int[]{
                1, 0, 0, 0
        }));
        System.out.println(l.maxDistToClosest(new int[]{
                0, 1
        }));
//        System.out.println(l.numMagicSquaresInside(new int[][]{
//                {4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}
//        }));
    }


    public int maxDistToClosest(int[] seats) {
        int pre = -1;
        int ret = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (pre == -1 && i > 0) {
                    ret = Math.max(i, ret);
                } else {
                    ret = Math.max((i - pre) / 2, ret);
                }
                pre = i;
            }
        }
        if (pre < seats.length - 1) {
            ret = Math.max(seats.length - 1 - pre, ret);
        }
        return ret;
    }

    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift : shifts) {
            X = (X + shift) % 26;
        }
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 'a'));
            X = Math.floorMod(X - shifts[i], 26);
        }
        return ans.toString();
    }


}
