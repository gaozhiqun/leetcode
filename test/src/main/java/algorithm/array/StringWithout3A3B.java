package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午5:02
 */
public class StringWithout3A3B {
    public static void main(String[] args) {
        StringWithout3A3B stringWithout3A3B = new StringWithout3A3B();
        System.out.println(stringWithout3A3B.stringWithout3A3B(1, 2));
        System.out.println(stringWithout3A3B.stringWithout3A3B(4, 1));
        System.out.println(stringWithout3A3B.stringWithout3A3B(4, 11));
    }

    public String stringWithout3A3B(int M, int N) {
        int l = M, s = N;
        char a = 'a', b = 'b';
        if (s > l) {
            s = M;
            l = N;
            a = 'b';
            b = 'a';
        }
        if (l > 2 * s + 2) {
            return "";
        }
        StringBuilder ans = new StringBuilder("");
        while (l > s) {
            for (int i = 0; i < 2; ++i) {
                if (l > 0) {
                    ans.append(a);
                    --l;
                }
            }
            if (s > 0) {
                ans.append(b);
                --s;
            }
        }
        while (l > 0 || s > 0) {
            if (l > 0) {
                ans.append(a);
                --l;
            }
            if (s > 0) {
                ans.append(b);
                --s;
            }
        }
        return ans.toString();
    }
}
