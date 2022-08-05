package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/4 上午11:13
 */
public class Leetcode_925_isLongPressedName {
    public static void main(String[] args) {
        Leetcode_925_isLongPressedName l = new Leetcode_925_isLongPressedName();
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }

}
