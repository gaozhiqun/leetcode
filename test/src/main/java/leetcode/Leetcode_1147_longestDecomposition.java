package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午10:59
 */
public class Leetcode_1147_longestDecomposition {
    public static void main(String[] args) {
        Leetcode_1147_longestDecomposition l = new Leetcode_1147_longestDecomposition();
        System.out.println(l.longestDecomposition("elvtoelvto"));
        System.out.println(l.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(l.longestDecomposition("merchant"));
        System.out.println(l.longestDecomposition("aaa"));
        System.out.println(l.longestDecomposition("antaprezatepzapreanta"));
    }


    public int longestDecomposition(String text) {
        int m = text.length();
        return processing(text, 0, text.length() - 1);
    }

    private int processing(String s, int l, int r) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        while (l < r) {
            prefix.append(s.charAt(l++));
            suffix.insert(0, s.charAt(r--));
            if (prefix.toString().equals(suffix.toString())) {
                if (l > r) {
                    return 2;
                } else {
                    return 2 + processing(s, l, r);
                }
            }
        }
        return 1;
    }


}
