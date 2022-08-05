package algorithm.huawei;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午10:30
 */
public class DigitsWith7 {

    /**
     * 7 的倍数
     * 17/27/37/47/57/67/77
     * 77
     * 1≤n≤30000
     *
     * @param n
     * @return
     */
    private int get7(int n) {
        int ret = 0;
        for (int i = 7; i <= n; ++i) {
            ret += String.valueOf(n).contains("7") || n % 7 == 0 ? 1 : 0;
        }
        return ret;

    }
}
