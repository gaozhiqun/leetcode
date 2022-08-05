package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午5:24
 */
public class Leetcode_12_intToRoma {

    public static void main(String[] args) {
        Leetcode_12_intToRoma l = new Leetcode_12_intToRoma();
        System.out.println(l.intToRoman(1994));
        System.out.println(l.intToRoman(58));
    }

    String[][] romans = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"M", "MM", "MMM"}
    };

    /**
     * 1<=num<=3999
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int i = 0;
        String ans = "";
        while (num != 0) {
            int r = num % 10;
            if (r > 0) {
                ans = romans[i][r - 1] + ans;
            }
            num /= 10;
            ++i;
        }
        return ans;
    }
}
