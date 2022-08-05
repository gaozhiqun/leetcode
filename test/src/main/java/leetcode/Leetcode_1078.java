package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午7:01
 */
public class Leetcode_1078 {


    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        List<String> ret = new ArrayList<>();
        for (int i = 2; i < texts.length; ++i) {
            if (first.equals(texts[i - 2]) && second.equals(texts[i - 1])) {
                ret.add(texts[i]);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

}
