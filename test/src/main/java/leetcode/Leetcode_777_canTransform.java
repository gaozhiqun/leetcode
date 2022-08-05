package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_777_canTransform {

    public static void main(String[] args) {
        Leetcode_777_canTransform l = new Leetcode_777_canTransform();
    }

    /**
     * LX -> XL XR->RX
     * R 只能前移，L只能后移
     *
     * @param start
     * @param end
     * @return
     */

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') {
                    t++;
                }
                if (i < t++) {
                    return false;
                }
            }
        }
        t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') {
                    t++;
                }
                if (i > t++) {
                    return false;
                }
            }
        }
        return true;
    }


}