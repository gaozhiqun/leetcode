package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_69_mySqrt {

    public static void main(String[] args) {
        Leetcode_69_mySqrt l = new Leetcode_69_mySqrt();
        System.out.println(l.mySqrt(1));
        System.out.println(l.mySqrt(2));
        System.out.println(l.mySqrt(3));
        System.out.println(l.mySqrt(4));
        System.out.println(l.mySqrt(5));
        System.out.println(l.mySqrt(6));
        System.out.println(l.mySqrt(7));
        System.out.println(l.mySqrt(8));
        System.out.println(l.mySqrt(9));
        //System.out.println(l.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        //System.out.println(l.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    /**
     * 8
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


}
