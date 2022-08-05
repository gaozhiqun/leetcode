package leetcode;

import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_479_largestPalindrome {

    public static void main(String[] args) {
        Leetcode_479_largestPalindrome l = new Leetcode_479_largestPalindrome();
        System.out.println(l.largestPalindrome(1));
        System.out.println(l.largestPalindrome(2));
        System.out.println(l.largestPalindrome(3));
        System.out.println(l.largestPalindrome(4));
        System.out.println(l.largestPalindrome(5));
        System.out.println(l.largestPalindrome(6));
        System.out.println(l.largestPalindrome(7));
        System.out.println(l.largestPalindrome(8));

    }

    public int largestPalindrome2(int n) {
        int largest = (int) Math.pow(10, n) - 1;// n位最大数
        long max = (long) Math.pow(largest, 2);// 平方最大值
        for (int i = largest - 1; i > 0; i--) {
            long num = getNextNum(i);// i同i镜像组成的回文数
            for (long ans = largest; num <= max && ans * ans >= num; ans--) {
                if (num % ans == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 9;
    }

    private long getNextNum(int cur) {
        long temp = cur;
        while (cur > 0) {
            temp *= 10;
            temp += cur % 10;
            cur /= 10;
        }
        return temp;
    }

    public int largestPalindrome(int n) {
        int largest = (int) Math.pow(10, n) - 1;
        long max = (long) Math.pow(largest, 2);
        for (int i = largest - 1; i > 0; i--) {
            long num = getNextNum(i);
            for (long ans = largest; num <= max && ans * ans >= num; ans--) {
                if (num % ans == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 9;
    }

    private long palindrome(int num) {
        long mirror = 0;
        long ans = num;
        while (num > 0) {
            mirror = mirror * 10 + num % 10;
            ans *= 10;
            num /= 10;
        }
        return ans + mirror;
    }


}
