package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/27 下午5:26
 */
public class SumEvenAfterQueries {
    public static void main(String[] args) {
        SumEvenAfterQueries sumEvenAfterQueries = new SumEvenAfterQueries();
        int[] ans = sumEvenAfterQueries.sumEvenAfterQueries(new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}});

        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int M = queries.length;
        int[] ans = new int[M];
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int val = query[0], index = query[1];
            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            ans[i] = sum;
        }
        return ans;

    }
}
