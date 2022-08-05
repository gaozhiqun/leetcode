package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_172_trailingZeroes {

    public static void main(String[] args) {
        Leetcode_172_trailingZeroes l = new Leetcode_172_trailingZeroes();
        System.out.println(l.trailingZeroes(5));
        System.out.println(l.trailingZeroes(30));
    }

    public int trailingZeroes(int n) {
        int base = 5, ans = 0;
        while (base <= n) {
            ans += n / base;
            base *= 5;
        }
        return ans;
    }
}