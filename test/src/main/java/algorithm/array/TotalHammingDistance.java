package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/20 上午10:51
 */
public class TotalHammingDistance {
    public static void main(String[] args) {
        TotalHammingDistance totalHammingDistance = new TotalHammingDistance();
        System.out.println(totalHammingDistance.totalHammingDistance(new int[]{4, 14, 2}));
    }

    public int totalHammingDistance(int[] nums) {
        int[] ones = new int[32];
        int result = 0;
        for (int i = 0; i <= 30; i++) {
            for (int num : nums) {
                ones[i] += (num >> i & 1) > 0 ? 1 : 0;
            }
            result += (nums.length - ones[i]) * ones[i];

        }
        return result;
    }
}
