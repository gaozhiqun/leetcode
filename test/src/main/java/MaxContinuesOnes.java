

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/19 8:32 下午
 */
public class MaxContinuesOnes {
    public static void main(String[] args) {

    }

    public int maxContinuesOnes(int[] array, int n) {
        int l = 0, r = 0, result = 0, temp = 0;
        int zeroLeft = n;
        for (int cur : array) {
            if (cur == 1) {
                temp++;
                result = Math.max(temp, result);
            } else {
                if (zeroLeft == 0) {
                    while (array[l] == 1) {
                        l++;
                        temp--;
                    }
                    ++l;
                    zeroLeft++;
                    temp--;
                }
                if (zeroLeft > 0) {
                    zeroLeft--;
                    temp++;
                }
            }
        }
        return result;
    }
}
