package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/13 下午5:35
 */
public class Leetcode_767_reorganizeString {
    public static void main(String[] args) {
        Leetcode_767_reorganizeString l = new Leetcode_767_reorganizeString();
        System.out.println(l.reorganizeString("aab"));
        System.out.println(l.reorganizeString("aabbcc"));
    }

    public String reorganizeString(String s) {
        int[] cnts = new int[27];
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        int pre = -1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int next = 26;
            for (int c = 0; c < 26; c++) {
                if (c == pre) {
                    continue;
                }
                if (cnts[c] > cnts[next]) {
                    next = c;
                }
            }
            if (next == 26) {
                return "";
            }
            stringBuilder.append((char) (next + 'a'));
            cnts[next]--;
            pre = next;
        }
        return stringBuilder.toString();
    }

}
