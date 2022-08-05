package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_306_isAdditiveNumber {

    public static void main(String[] args) {

    }

    /**
     * 字符串
     */
    String s;
    /**
     * 字符串的长度
     */
    int n;

    public boolean isAdditiveNumber(String num) {
        this.s = num;
        this.n = num.length();
        return toFlashBack(0, 0, 0, 0);
    }

    public boolean toFlashBack(int index, long sum, long previous, int count) {
        // 如果已生成三个数及以上则返回 true
        if (index == n) {
            return count >= 3;
        }
        // 拼接数字的值，值可能越 int 界所以使用 long
        long value = 0;
        // 开始拼接数字
        for (int i = index; i < n; i++) {
            // 除 0 以外，其他数字第一位不能为 0
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            // 计算数值
            value = value * 10 + s.charAt(i) - '0';
            // 判断数值是否合法，如果前面有两个以上的数，则判断前两个数的和是否等于这个数
            if (count >= 2) {
                if (value < sum) {
                    // 小的话继续向后继续拼接
                    continue;
                } else if (value > sum) {
                    // 大的话直接结束，再往后拼接无意义
                    break;
                }
            }
            // 使用该数，向下递归
            if (toFlashBack(i + 1, previous + value, value, count + 1)) {
                return true;
            }
            // 没有可恢复原样的变量
        }
        return false;
    }

}
