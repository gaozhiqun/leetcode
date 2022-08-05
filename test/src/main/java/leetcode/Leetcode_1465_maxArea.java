package leetcode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/1 下午2:55
 */
public class Leetcode_1465_maxArea {


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int u = 0, l = 0, vmax = 0, hmax = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i : verticalCuts) {
            vmax = Math.max(i - l, vmax);
            l = i;
        }
        vmax = Math.max(w - l, vmax);

        for (int i : horizontalCuts) {
            hmax = Math.max(i - u, hmax);
            u = i;
        }
        hmax = Math.max(h - u, hmax);

        return vmax * hmax;

    }


}
