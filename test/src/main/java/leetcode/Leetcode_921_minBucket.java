package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/4 上午11:13
 */
public class Leetcode_921_minBucket {
    public int minAddToMakeValid(String s) {
        int ret = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++cnt;
            } else {
                --cnt;
                if (cnt < 0) {
                    ++ret;
                    ++cnt;
                }
            }
        }
        return ret + cnt;
    }
}
