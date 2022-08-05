package algorithm.sort;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午7:33
 */
public class OrderlyQueue {
    public static void main(String[] args) {

    }

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String next = s.substring(i) + s.substring(0, i);
                if (next.compareTo(ans) < 0) {
                    ans = next;
                }
            }
            return ans;
        } else {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }
}
