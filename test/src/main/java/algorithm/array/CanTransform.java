package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 上午11:26
 */
public class CanTransform {
    public static void main(String[] args) {

    }

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
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
