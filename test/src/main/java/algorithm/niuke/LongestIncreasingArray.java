package algorithm.niuke;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/2 下午2:32
 */
public class LongestIncreasingArray {


    public int[] LIS_binary(int[] arr) {
        int m = arr.length;
        int[] mins = new int[m];
        int[] lens = new int[m];
        lens[0] = 1;
        mins[0] = arr[0];
        int idx = 0;
        for (int i = 1; i < m; ++i) {
            if (arr[i] > mins[idx]) {
                mins[++idx] = arr[i];
                lens[i] = idx + 1;
            } else {
                int l = 0, r = idx;
                while (l <= r) {
                    int mid = (r + l) / 2;
                    if (mins[mid] >= arr[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                mins[l] = arr[i];
                lens[i] = l + 1;
            }
        }
        int[] ret = new int[idx + 1];
        for (int i = lens.length - 1; i >= 0; --i) {
            if (lens[i] == idx + 1) {
                ret[idx--] = arr[i];
            }
        }
        return ret;
    }

}
