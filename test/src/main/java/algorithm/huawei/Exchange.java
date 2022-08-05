package algorithm.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 下午4:19
 */
public class Exchange {


    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        Scanner in = new Scanner(System.in);
        System.out.println(exchange.transLate(in.nextLine()));
    }

    private static String[] DIGITS_CHINESE = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static String[] CARRAYS = {"", "拾", "佰", "仟"};
    private static String[] CNT = {"元", "万", "亿"};

    private String transLate(String digit) {
        String[] splits = digit.split("\\.");
        StringBuilder ret = new StringBuilder("人民币");
        String intPart = splits[0];
        String changePart = splits[1];
        String change = getChanges(changePart);
        LinkedList<String> linkedList = new LinkedList<>();
        int r = intPart.length();
        int i = 0;
        while (r > 0) {
            int l = Math.max(0, r - 4);
            String cur = intPart.substring(l, r);
            linkedList.addFirst(getBelowWan(cur, CNT[i++]));
            r = l;
        }
        if (linkedList.isEmpty()) {
            ret.append("零元");
        } else {
            while (!linkedList.isEmpty()) {
                ret.append(linkedList.poll());
            }
        }
        ret.append(change);
        return ret.toString();
    }

    private String getChanges(String change) {
        if ("".equals(change) || "0".equals(change) || "00".equals(change)) {
            return "整";
        }
        if ('0' == change.charAt(0)) {
            return String.format("%s分",
                    DIGITS_CHINESE[change.charAt(1) - '0']);
        } else if ('0' == change.charAt(1)) {
            return String.format("%s角",
                    DIGITS_CHINESE[change.charAt(0) - '0']);
        }
        return String.format("%s角%s分",
                DIGITS_CHINESE[change.charAt(0) - '0'],
                DIGITS_CHINESE[change.charAt(1) - '0']);
    }

    private String getBelowWan(String m, String cnt) {
        if ("0".equals(m)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int carryIdex = m.length() - 1;
        boolean zeroFound = false;
        for (int i = 0; i < m.length(); ++i) {
            int k = m.charAt(i) - '0';
            if (k == 0) {
                zeroFound = true;
            } else {
                if (zeroFound) {
                    zeroFound = false;
                    stringBuilder.append("零");
                }
                if (!(k == 1 && carryIdex == 1)) {
                    stringBuilder.append(DIGITS_CHINESE[k]);
                }
                stringBuilder.append(CARRAYS[carryIdex--]);
            }
        }
        stringBuilder.append(cnt);
        return stringBuilder.toString();
    }
}
