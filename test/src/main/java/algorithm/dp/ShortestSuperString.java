package algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午4:05
 */
public class ShortestSuperString {
    public static void main(String[] args) {

    }

    /**
     * (1)(23) (1)(2)(3) (12)(3)
     *
     * @param words
     * @return
     */
    public String shortestSuperString(String[] words) {
        int m = words.length;
        return "";
    }

    public List<String> contact(String s1, String s2) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s1.length(); i++) {
            if (s2.startsWith(s1.substring(0))) {
                result.add(s1.substring(0, i) + s2);
            }
        }
        return result;
    }
}
