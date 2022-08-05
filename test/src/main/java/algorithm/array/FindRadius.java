package algorithm.array;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/7/22 下午5:38
 */
public class FindRadius {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int j = 0;
        int[] mostRecent = new int[houses.length];
        int result = Integer.MIN_VALUE;
        Arrays.fill(mostRecent, Integer.MAX_VALUE);
        for (int i = 0; i < houses.length; i++) {
            mostRecent[i] = heaters[j] - houses[i];
            while (j + 1 < heaters.length && heaters[j + 1] - houses[i] < mostRecent[i]) {
                mostRecent[i] = heaters[++j] - houses[i];
            }
            result = Math.max(mostRecent[i], result);
        }
        return result;
    }
}
