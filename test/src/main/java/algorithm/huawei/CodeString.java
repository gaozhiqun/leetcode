package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/25 下午1:04
 */
public class CodeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String coder = in.nextLine();
        String s = in.nextLine();
        System.out.println(encode(coder, s));
    }


    public static String encode(String coder, String s) {
        int[] coders = getCoder(coder);
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append((char) (coders[ch - 'a'] + 'a'));
        }
        return sb.toString();
    }


    static int[] getCoder(String s) {
        boolean[] used = new boolean[26];
        int[] coder = new int[26];
        int idx = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            if (!used[c]) {
                coder[idx++] = c;
                used[c] = true;
            }
        }
        for (int i = 0; i < used.length; ++i) {
            if (!used[i]) {
                coder[idx++] = i;
            }
        }
        return coder;
    }
}
