package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_6_Zconvert {
    public static void main(String[] args) {
        Leetcode_6_Zconvert l = new Leetcode_6_Zconvert();
        System.out.println(l.convert("PAYPALISHIRING", 3));
        System.out.println(l.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sbs[i] = new StringBuilder();
        }
        int col = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); ++i) {
            sbs[col].append(s.charAt(i));
            if (col == numRows - 1) {
                down = false;
            } else if (col == 0) {
                down = true;
            }
            if (down) {
                ++col;
            } else {
                --col;
            }
        }
        for (int i = 1; i < numRows; ++i) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
