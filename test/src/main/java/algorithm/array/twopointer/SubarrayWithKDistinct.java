package algorithm.array.twopointer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 上午10:22
 */
public class SubarrayWithKDistinct {


    public static void main(String[] args) {

    }

    /**
     * leetcode 992
     * 类似的题有 76/209/159/424
     *
     * @param A
     * @param k
     * @return
     */

    public int subarrayWithKDistinct(int[] A, int k) {
        return atMostKDistinct(A, k) - atMostKDistinct(A, k - 1);

    }

    private int atMostKDistinct(int[] A, int k) {
        int M = A.length;
        int[] freq = new int[M];
        int count = 0, l = 0, r = 0, ans = 0;
        while (r < M) {
            if (freq[A[r]] == 0) {
                ++count;
            }
            freq[A[r]]++;
            ++r;
            while (count > k) {
                freq[A[l]]--;
                if (freq[A[l]] == 0) {
                    count--;
                }
                ++l;
            }
            ans += r - l;
        }
        return ans;
    }
}
