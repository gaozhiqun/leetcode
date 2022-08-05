package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/7 下午8:34
 */
public class FindSubStringInWraproundString {

    public static void main(String[] args) {

    }

    public int findSubStringInWraproundString(String p) {
        int[] counts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int max = 0;
            if ((i > 0) && (p.charAt(i) == p.charAt(i - 1) + 1 || p.charAt(i - 1) == 'z' && p.charAt(i) == 'a')) {
                max++;
            } else {
                max = 1;
            }
            counts[p.charAt(i)-'a'] = Math.max(max, counts[p.charAt(i)-'a']);
        }
        int result = 0;
        for (int i : counts) {
            result += i;
        }
        return result;
    }

}
