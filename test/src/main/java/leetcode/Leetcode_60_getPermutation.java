package leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_60_getPermutation {

    public static void main(String[] args) {
        Leetcode_60_getPermutation l = new Leetcode_60_getPermutation();
        System.out.println(l.getPermutation(3, 2));
//        System.out.println(l.getPermutation(2, 2));
        System.out.println(l.getPermutation(3, 3));
        System.out.println(l.getPermutation(4, 9));
        System.out.println(l.getPermutation(3, 1));
    }


    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }
        k--;
        int total = getTotal(n - 1);
        StringBuilder an = new StringBuilder();
        for (int i = n; i > 0; --i) {
            int m = k / total;
            if (i > 1) {
                k %= total;
                total /= (i - 1);
            }
            an.append(list.remove(m));
        }
        return an.toString();
    }


    private int getTotal(int n) {
        int ans = 1;
        for (int i = n; i > 0; --i) {
            ans *= i;
        }
        return ans;
    }

}
