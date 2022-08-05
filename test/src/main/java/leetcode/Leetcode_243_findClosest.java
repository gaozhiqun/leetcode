package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_243_findClosest {
    public static void main(String[] args) {
        Leetcode_243_findClosest l = new Leetcode_243_findClosest();
        System.out.println(l.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"},
                "a", "student"));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int a = -1, b = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
                if (b != -1) {
                    ans = Math.min(ans, Math.abs(a - b));
                }
            } else if (words[i].equals(word2)) {
                b = i;
                if (a != -1) {
                    ans = Math.min(ans, Math.abs(b - a));
                }
            }
        }
        return ans;
    }

}
