package algorithm.dp;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/26 下午8:27
 */
public class CountTriplets {
    public static void main(String[] args) {

    }


    /**
     * (i,j,k) A[i]&A[j]&A[k]==0
     * 1<=A.length<1000
     * 0<=A[i]<2^16
     *
     * @param nums
     * @return
     */
    public int countTriplets(int[] nums) {
        int N = nums.length;
        int ans = 0;
        int k = 1;
        for (int i : nums) {
            while (k <= i) {
                k <<= 1;
            }
        }
        int[] mem = new int[k];
        for (int i : nums) {
            int mask = (k - 1) ^ i;
            int t = mask;
            while (true) {
                mem[t]++;
                if (t == 0) {
                    break;
                }
                t = (t - 1) & mask;
            }
        }
        //(i,j,k)->
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int a = nums[i], b = nums[j];
                ans += mem[a & b];
            }
        }
        return ans;
    }
}
