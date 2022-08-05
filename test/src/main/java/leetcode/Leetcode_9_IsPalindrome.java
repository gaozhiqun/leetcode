package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/29 下午2:37
 */
public class Leetcode_9_IsPalindrome {
    public static void main(String[] args) {
        Leetcode_9_IsPalindrome l = new Leetcode_9_IsPalindrome();
        System.out.println(l.isPalindrome(121));
        System.out.println(l.isPalindrome(3));
        System.out.println(l.isPalindrome(123));
        System.out.println(l.isPalindrome(-123));


    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
