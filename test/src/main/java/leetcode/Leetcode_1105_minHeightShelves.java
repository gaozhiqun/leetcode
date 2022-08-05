package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午12:38
 */
public class Leetcode_1105_minHeightShelves {

    public static void main(String[] args) {
        Leetcode_1105_minHeightShelves l = new Leetcode_1105_minHeightShelves();
        System.out.println(l.minHeightShelves(new int[][]{
                {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}
        }, 4));
    }


    public int minHeightShelves(int[][] books, int shelfWidth) {
        int m = books.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            int[] book = books[i];
            dp[i + 1] = dp[i] + book[1];
            int sum = book[0], pre = i - 1, height = book[1];
            while (pre >= 0 && sum < shelfWidth) {
                sum += books[pre][0];
                height = Math.max(height, books[pre][1]);
                if (sum <= shelfWidth) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[pre] + height);
                }
                --pre;
            }
        }
        return dp[m];
    }


}
