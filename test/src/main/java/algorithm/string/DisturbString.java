package algorithm.string;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/8 7:30 下午
 */
public class DisturbString {

    public boolean disturbString(String a, String b) {
        return recursiveDisturb(a, b, 0, a.length());
    }

    //1. Map 计数法
    private boolean recursiveDisturb(String s, String b, int l, int r) {
        if (l == r) {
            return false;
        }
        if (s.substring(l, r).equals(b.substring(l, r))) {
            return true;
        }
        for (int j = l + 1; j < r; j++) {
            if (recursiveDisturb(s, b, l, j) && recursiveDisturb(s, b, j, r)) {
                return true;
            }
        }
        return false;
    }



}
