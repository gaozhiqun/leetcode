package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午5:54
 */
public class Mp3 {

    public static void main(String[] args) {
        window(83, "UUDUDDDDUDUUDDDDUDD");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String op = scanner.nextLine();
        window(n, op);
    }


    public static void window(int n, String cmds) {
        int l = 0, r = 3, cursor = 0;
        for (char ch : cmds.toCharArray()) {
            if (ch == 'U') {
                if (n > 4 && cursor == l) {
                    if (l == 0) {
                        r = n - 1;
                        l = r - 3;
                    } else {
                        --l;
                        --r;
                    }
                }
                cursor--;
                if (cursor < 0) {
                    cursor += n;
                }
            } else if (ch == 'D') {
                if (n > 4 && cursor == r) {
                    if (r == n - 1) {
                        l = 0;
                        r = l + 3;
                    } else {
                        ++l;
                        ++r;
                    }
                }
                cursor = (++cursor) % n;
            }
        }
        StringBuilder window = new StringBuilder();
        if (n > 4) {
            for (int i = 0; i < 4; ++i) {
                window.append((l + i) % n + 1);
                window.append(" ");
            }
        } else {
            for (int i = 0; i < n; ++i) {
                window.append(i + 1);
                window.append(" ");
            }
        }
        window.deleteCharAt(window.length() - 1);
        System.out.println(window.toString());
        System.out.println(cursor + 1);

    }
}
