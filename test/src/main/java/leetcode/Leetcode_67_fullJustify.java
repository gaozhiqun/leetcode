package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_67_fullJustify {

    public static void main(String[] args) {
        Leetcode_67_fullJustify l = new Leetcode_67_fullJustify();
        System.out.println(l.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        //System.out.println(l.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        //System.out.println(l.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    /**
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     *
     * @param words
     * @param maxWidth
     * @return
     */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (l < words.length) {
            int len = 0;
            List<String> candidates = new ArrayList<>();
            while (r < words.length && len + words[r].length() <= maxWidth) {
                candidates.add(words[r]);
                len += words[r].length();
                ++len;
                ++r;
            }
            if (r < words.length) {
                ans.add(merge(candidates, maxWidth));
            } else {
                ans.add(mergeNoFill(candidates, maxWidth));
            }
            l = r;
        }
        return ans;
    }

    private String mergeNoFill(List<String> words, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : words) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        for (int i = stringBuilder.length(); i < maxWidth; ++i) {
            stringBuilder.append(" ");
        }
        if (stringBuilder.length() > maxWidth) {
            stringBuilder.delete(maxWidth, stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    private String merge(List<String> words, int maxWidth) {
        if (words.size() == 1) {
            StringBuilder stringBuilder = new StringBuilder(words.get(0));
            int todo = maxWidth - stringBuilder.length();
            for (int i = 0; i < todo; ++i) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
        int m = words.size();
        int len = 0;
        for (String s : words) {
            len += s.length();
        }
        int cntWhiteSpace = maxWidth - len;
        int average = cntWhiteSpace / (m - 1);
        int over = cntWhiteSpace % (m - 1);
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < m; ++i) {
            stringBuilder.append(words.get(i));
            if (i < over) {
                stringBuilder.append(" ");
            }
            if (i < m - 1) {
                for (int j = 0; j < average; ++j) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
