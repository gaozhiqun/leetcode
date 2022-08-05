package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/22 下午4:38
 */
public class Leetcode_899_orderlyQueue {

    /**
     * k 个字母中选择一个，并把它加到字符串的末尾。
     *
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ret = s;
            for (int i = 0; i < s.length(); ++i) {
                String n = s.substring(i) + s.substring(0, i);
                if (n.compareTo(ret) < 0) {
                    ret = n;
                }
            }
            return ret;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

    }
}
