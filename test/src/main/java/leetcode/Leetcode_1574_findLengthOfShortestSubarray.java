package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 上午10:33
 */
public class Leetcode_1574_findLengthOfShortestSubarray {

    /**
     * ① 删除左边一段，右边一段单调有序；
     * ② 删除中间中间一段，左右两段拼接起来单调有序；
     * ③ 删除右边一段，左边一段单调有序。
     *
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 1, j = n - 1;
        while (i < n && arr[i - 1] <= arr[i]) {
            ++i;
        }
        if (i == n) return 0;
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }
        int ans = j;
        int l = 0, r = j;
        while (l < i && r < n) {
            if (arr[l] <= arr[r]) {
                ans = Math.min(ans, r - l - 1);
                ++l;
            } else {
                ++r;
            }
        }
        ans = Math.min(ans, n - i);
        return ans;
    }
}
