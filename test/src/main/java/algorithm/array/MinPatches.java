package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/28 下午8:42
 */
public class MinPatches {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 10};
        MinPatches minPatches = new MinPatches();
        System.out.println(minPatches.minPatches(nums, 20));
    }

    /**
     * 1 1
     * 2 1 1
     * 3 1 1 1/ 1 2/ 3
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;//（补充一个x）
                patches++;
            }
        }
        return patches;
    }
}
