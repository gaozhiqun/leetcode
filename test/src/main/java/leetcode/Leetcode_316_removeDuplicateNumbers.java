package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_316_removeDuplicateNumbers {

    public static void main(String[] args) {
        Leetcode_316_removeDuplicateNumbers l = new Leetcode_316_removeDuplicateNumbers();
        System.out.println(l.removeDuplicateLetters("cbacdcbc"));

    }

    /**
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     */
    public String removeDuplicateLetters(String s) {
        int[] cnts = new int[26];
        boolean[] visited = new boolean[26];
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (!visited[ch - 'a']) {
                while (ans.length() > 0 && ans.charAt(ans.length() - 1) > ch) {
                    if (cnts[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                        visited[ans.charAt(ans.length() - 1) - 'a'] = false;
                        ans.deleteCharAt(ans.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                ans.append(ch);
            }
            cnts[ch - 'a']--;
        }
        return ans.toString();
    }


}