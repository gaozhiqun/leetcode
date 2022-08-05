package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_168_convertToTitle {

    public static void main(String[] args) {
        Leetcode_168_convertToTitle l = new Leetcode_168_convertToTitle();
        System.out.println(l.convertToTitle(28));
        System.out.println(l.convertToTitle(701));
        System.out.println(l.convertToTitle(2147483647));
        System.out.println(l.titleToNumber("FXSHRXW"));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        columnNumber--;
        while (columnNumber >= 0) {
            int m = columnNumber % 26;
            columnNumber /= 26;
            columnNumber--;
            ans.append((char) (m + 'A'));
        }
        return ans.reverse().toString();
    }

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans *= 26;
            ans += (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }


}