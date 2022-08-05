package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午7:03
 */
public class BagOfTokenScore {
    public static void main(String[] args) {
        BagOfTokenScore bagOfTokenScore = new BagOfTokenScore();
        System.out.println(bagOfTokenScore.bagOfTokenScore(200, new int[]{100, 200, 300, 400}));
    }

    public int bagOfTokenScore(int P, int[] A) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int ans = 0, score = 0;
        while (l <= r && P >= A[l] || score > 0) {
            if (P >= A[l]) {
                P -= A[l++];
                score++;
                ans = Math.max(ans, score);
            } else {
                P += A[r--];
                score--;
            }
        }
        return ans;
    }
}
