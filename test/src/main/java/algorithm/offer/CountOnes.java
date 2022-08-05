package algorithm.offer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/10 2:04 下午
 */
public class CountOnes {

    public static void main(String[] args) {
        CountOnes countOnes = new CountOnes();
        System.out.println(countOnes.countOnes(13));
        System.out.println(countOnes.countOnes(0));

    }

    /**
     * 10叉树
     *
     * @param n
     * @return
     */
    private int countOnes9(int n) {
        int result = 0;
        int digit = 1;
        //高位个数
        int high = n / 10;

        int cur = n % 10;
        //低位子树个数
        int low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                result += high * digit;
            } else if (cur == 1) {
                result += high * digit + low + 1;
                //加上子树个数 +1
            } else {
                result += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return result;
    }

    /**
     * 枚举每一个数位，分别统计该数位上数字 1 出现的次数
     */
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            //min(max(n′−100+1,0),100)
            ans += (n / (mulk * 10)) * mulk//（整数部分）
                    + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);//（余数部分）
            mulk *= 10;
        }
        return ans;
    }

    /**
     * 1）当 n' < 100n <100 时，「百位」上不会出现 1；
     * 2）当 100<= n' < 200 时，「百位」上出现 1 的范围为[100, n'] 所以出现了  n' - 100 + 1
     * 3）≥200 时，「百位」上出现了全部 100次1
     */

    private int countOnes(int n) {
        long base = 1;
        int ret = 0;
        while (n >= base) {
            ret += (n / (base * 10)) * base
                    + Math.min(Math.max(0, n % (base * 10) - base + 1), base);
            base *= 10;
        }
        return ret;
    }


}
