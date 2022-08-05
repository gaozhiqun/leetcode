package algorithm;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/4/27 3:36 下午
 */
public class Manacher {


    /**
     * 在字符串首尾及每个字符间都插入一个 "#"，这样可以使得原先的奇偶回文都变为奇回文；
     * 接着再在首尾两端各插入 "$" 和 "^"，这样中心扩展寻找回文的时候会自动退出循环，不需每次判断是否越界，可参见下面代码。
     * 上述新插入的三个字符，即 "#"、 "$" 和 "^"，必须各异，且不可以与原字符串中的字符相同。
     * 举个例子：s="abbahopxpo"，转换为 s_new="$#a#b#b#a#h#o#p#x#p#o#^"。如此，s 里起初有一个偶回文 abba 和一个奇回文 opxpo，被转换为 #a#b#b#a# 和 #o#p#x#p#o#，长度都转换成了奇数。
     * 定义一个辅助数组 int p[]，其中 p[i] 表示以 i 为中心的最长回文的半径，例如：
     */

    private String s;

    private String init(String a) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder("^");
        for (Character ch : s.toCharArray()) {
            stringBuilder.append(ch);
            stringBuilder.append("#");
        }
        stringBuilder.append("$");
        return stringBuilder.toString();
    }

    private int manacher(String s) {
        String newStr = init(s);
        int[] rad = new int[newStr.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i++) {
            // 2.1.确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            // 2.2.尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }
            // 2.3.更新边界和回文中心坐标
            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }

        // 3.扫描一遍rad数组，找出最大的半径
        int maxLength = 0;
        for (int r : rad) {
            if (r > maxLength) {
                maxLength = r;
            }
        }
        return maxLength - 1;
    }


}
