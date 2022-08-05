package leetcode;


import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_134_candy {

    public static void main(String[] args) {
        Leetcode_134_candy l = new Leetcode_134_candy();
        System.out.println(l.candy(new int[]{1, 0, 2}));
        System.out.println(l.candy(new int[]{1, 2, 2}));
        System.out.println(l.candy2(new int[]{1, 0, 2}));
        System.out.println(l.candy2(new int[]{1, 2, 2}));
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */

    }

    /**
     * [1,0,2]
     * 每个孩子至少分配到 1 个糖果。
     * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
     *
     * @param ratings
     * @return
     */

    public int candy(int[] ratings) {
        int m = ratings.length;
        int ans = 0;
        int[] assign = new int[m];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            return a[1] - b[1];//按照分数从小到大排序
        });
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, ratings[i]});
        }
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int candy = 1, i = next[0], rating = next[1];
            if (i > 0 && ratings[i - 1] < rating) {
                candy = Math.max(assign[i - 1] + 1, candy);
            }
            if (i < m - 1 && ratings[i + 1] < rating) {
                candy = Math.max(assign[i + 1] + 1, candy);
            }
            assign[i] = candy;
            ans += candy;
        }
        return ans;
    }

    public int candy2(int[] ratings) {
        int m = ratings.length;
        int ans = 0;
        int[] rights = new int[m];
        int[] lefts = new int[m];
        lefts[0] = 1;
        rights[m - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rights[i] = rights[i + 1] + 1;
            } else {
                rights[i] = 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                lefts[i] = lefts[i - 1] + 1;
            } else {
                lefts[i] = 1;
            }
        }
        for (int i = 0; i < m; ++i) {
            ans += Math.max(lefts[i], rights[i]);
        }
        return ans;
    }
}