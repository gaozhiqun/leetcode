package algorithm.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午7:57
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(getDigits(line));
        }
      //  System.out.println(getDigits("A10;S20;W10;D30;X;A1A;B10A11;;A10;"));
    }

    public static String getDigits(String cmds) {
        String[] cmdArray = cmds.split(";");
        int[] ret = new int[]{0, 0};
        for (String s : cmdArray) {
            int[] moves = getMoves(s.trim());
            ret[0] += moves[0];
            ret[1] += moves[1];
        }
        return String.format("%s,%s", ret[0], ret[1]);
    }

    private static int[] getMoves(String cmd) {
        if (cmd.isEmpty()) {
            return new int[]{0, 0};
        }
        int i = 0, d = 0;
        char cmdChar = cmd.charAt(i++);
        int[] base;
        if ('W' == cmdChar || 'w' == cmdChar) {
            base = new int[]{0, 1};
        } else if ('S' == cmdChar || 's' == cmdChar) {
            base = new int[]{0, -1};
        } else if ('A' == cmdChar || 'a' == cmdChar) {
            base = new int[]{-1, 0};
        } else if ('D' == cmdChar || 'd' == cmdChar) {
            base = new int[]{1, 0};
        } else {
            return new int[]{0, 0};
        }
        while (i < cmd.length() && Character.isDigit(cmd.charAt(i))) {
            d *= 10;
            d += (cmd.charAt(i++) - '0');
        }
        return i == cmd.length() ? new int[]{base[0] * d, base[1] * d} : new int[]{0, 0};
    }

}
