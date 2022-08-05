package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_481_magicalString {

    public static void main(String[] args) {
        Leetcode_481_magicalString l = new Leetcode_481_magicalString();
        System.out.println(l.magicalString(20));
        System.out.println(l.magicalString(6));

    }

    /**
     * 122112
     * 1 22 11 2 1 22 1 22 11 2 11 22 ......
     *
     * @param n
     * @return
     */
    public int magicalString(int n) {
        int ans = 1;
        StringBuilder cur = new StringBuilder("122");
        int l = 2, next = 1;
        while (cur.length() < n) {
            int k = Math.min(n - cur.length(), cur.charAt(l++) - '0');
            for (int i = 0; i < k; i++) {
                cur.append(next);
            }
            if (next == 1) {
                ans += k;
                next = 2;
            } else {
                next = 1;
            }
        }
        return ans;
    }


}
