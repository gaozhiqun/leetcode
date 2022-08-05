package algorithm.array;

import java.util.Random;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/8/26 上午10:15
 */
public class WeightedSelect {
    public static void main(String[] args) {
        WeightedSelect weightedSelect = new WeightedSelect(new int[]{1, 3, 5, 7, 9});
        System.out.println(weightedSelect.pickIndex());
        System.out.println(weightedSelect.pickIndex());
        System.out.println(weightedSelect.pickIndex());
        System.out.println(weightedSelect.pickIndex());
        System.out.println(weightedSelect.pickIndex());
    }

    private int[] w;
    private int total;
    private int[] wPrefix;
    private Random rand;

    public WeightedSelect(int[] w) {
        this.w = w;
        this.wPrefix = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            wPrefix[i] = total;
        }
        rand = new Random();
    }

    public int pickIndex() {
        int rand = this.rand.nextInt(total);
        int l = 0, r = w.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (rand > wPrefix[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
