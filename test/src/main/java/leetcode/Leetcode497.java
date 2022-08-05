package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode497 {

    public static void main(String[] args) {
        Leetcode497 leetcode_494_findTargetSum = new Leetcode497();
    }

    public static class Solution {

        int[][] rects;
        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public Solution(int[][] rects) {
            this.rects = rects;
            for (int[] x : rects) {
                tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
                psum.add(tot);
            }
        }

        public int[] pick() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = rects.length - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }

            int[] x = rects[lo];
            int width = x[2] - x[0] + 1;
            int height = x[3] - x[1] + 1;
            int base = psum.get(lo) - width * height;
            return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
        }

        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i : deck) {
                cnt.put(i, cnt.getOrDefault(i, 0) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (int d : cnt.values()) {
                min = Math.min(min, d);
            }
            outter:
            for (int i = 2; i <= min; ++i) {
                for (int d : cnt.values()) {
                    if (d % i != 0) {
                        continue outter;
                    }
                }
                return true;
            }
            return false;
        }

    }


}
