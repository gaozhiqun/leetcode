package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 下午4:28
 */
public class KthGrammar {
    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        System.out.println(kthGrammar.kthGrammar(4, 5));
        System.out.println(kthGrammar.kthGrammar(2, 1));
        System.out.println(kthGrammar.kthGrammar(1, 1));
    }

    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int total = (int) Math.pow(2, n - 1);
        if (k > total / 2) {
            return kthGrammar(n - 1, k - total / 2) == 1 ? 0 : 1;
        } else {
            return kthGrammar(n - 1, k);
        }
    }
}
