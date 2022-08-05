package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/17 上午11:15
 */
public class IsDealPermutation {
    public static void main(String[] args) {

    }

    /**
     * 0<=i<j<n
     * nums[i]>nums[j]
     * <p>
     * 0<=i<n-1
     * nums[i]>nums[i+1]
     *
     * @param nums
     * @return
     */
    public boolean isDealPermutation(int[] nums) {
        int N = nums.length;
        int floor = N;
        for (int i = N - 1; i > 1; --i) {
            floor = Math.min(floor, nums[i]);
            if (floor < nums[i - 2]) {
                return false;
            }
        }
        return true;
    }

}
