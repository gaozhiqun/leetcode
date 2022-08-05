package algorithm.huawei;


import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/26 下午3:07
 */
public class XUTF {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(getXutf(line));
    }


    public static int getXutf(String s) {
        if (!checkHex(s)) {
            return -1;
        }
        String hex = toBinary(s);
        int m = s.length() / 2;
        if (m == 1) {
            if (!hex.startsWith("0")) {
                return -1;
            }
            return getBinary(s);
        }
        hex = hex.substring(hex.length() - 8 * m);
        StringBuilder retBuilder = new StringBuilder();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < m; ++i) {
            prefix.append("1");
        }
        prefix.append("0");
        for (int i = 0; i < hex.length(); i += 8) {
            String cur = hex.substring(i, i + 8);
            if (i > 0) {
                if (!cur.startsWith("10")) {
                    return -1;
                } else {
                    retBuilder.append(cur.substring(2));
                }
            } else {
                if (!cur.startsWith(prefix.toString())) {
                    return -1;
                } else {
                    retBuilder.append(cur.substring(prefix.length()));
                }
            }
        }

        return getBinary(retBuilder.toString());
    }


    private static int getBinary(String binary) {
        int ret = 0;
        for (char ch : binary.toCharArray()) {
            ret *= 2;
            ret += (ch - '0');
        }
        return ret;
    }


    private static boolean checkHex(String s) {
        for (char ch : s.toCharArray()) {
            if ('0' <= ch && ch <= '9'
                    || 'a' <= ch && ch <= 'f'
                    || 'A' <= ch && ch <= 'F') {
                continue;
            }
            return false;
        }
        return true;
    }


    private static int getHex(String s) {
        int ret = 0;
        for (char ch : s.toCharArray()) {
            ret *= 16;
            if ('0' <= ch && ch <= '9') {
                ret += ch - '0';
            } else if ('a' <= ch && ch <= 'f') {
                ret += ch - 'a' + 10;
            } else if ('A' <= ch && ch <= 'F') {
                ret += ch - 'A' + 10;
            }
        }
        return ret;
    }

    private static String toBinary(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            stringBuilder.append(getBinary(ch));
        }
        return stringBuilder.toString();
    }

    private static String getBinary(Character ch) {
        int d = 0;
        if ('0' <= ch && ch <= '9') {
            d += ch - '0';
        } else if ('a' <= ch && ch <= 'f') {
            d += ch - 'a' + 10;
        } else if ('A' <= ch && ch <= 'F') {
            d += ch - 'A' + 10;
        }
        StringBuilder ret = new StringBuilder();
        while (d > 0) {
            ret.append(d % 2);
            d /= 2;
        }

        while (ret.length() < 4) {
            ret.append("0");
        }
        return ret.reverse().toString();
    }


}
