package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_779_kthGrammar {
    public static void main(String[] args) {
        Leetcode_779_kthGrammar l = new Leetcode_779_kthGrammar();
        System.out.println(l.kthGrammar(2, 2));
        System.out.println(l.kthGrammar(4, 5));
    }


    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int half = (1 << (n - 2));
        if (k > half) {
            return kthGrammar(n - 1, k - half) == 1 ? 0 : 1;
        }
        return kthGrammar(n - 1, k);
    }
}
