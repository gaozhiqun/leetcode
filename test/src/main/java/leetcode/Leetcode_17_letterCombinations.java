package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午6:14
 */
public class Leetcode_17_letterCombinations {
    public static void main(String[] args) {
        Leetcode_17_letterCombinations l = new Leetcode_17_letterCombinations();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations(""));
        System.out.println(l.letterCombinations("2"));
    }

    private static char[][] NUM_ALPHABET = {{' '}, {'!', '@', '*'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String digits, int cur, StringBuilder temp, List<String> ans) {
        if (cur == digits.length()) {
            ans.add(temp.toString());
            return;
        }
        int digit = digits.charAt(cur) - '0';
        for (char ch : NUM_ALPHABET[digit]) {
            temp.append(ch);
            dfs(digits, cur + 1, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }
    }


}

