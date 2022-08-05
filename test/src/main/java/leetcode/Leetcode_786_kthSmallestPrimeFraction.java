package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/17 上午10:53
 */
public class Leetcode_786_kthSmallestPrimeFraction {
    public static void main(String[] args) {
        Leetcode_786_kthSmallestPrimeFraction l = new Leetcode_786_kthSmallestPrimeFraction();
        System.out.println(l.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> {
            return arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]];
        });
        boolean[][] visited = new boolean[n][n];
        priorityQueue.offer(new int[]{0, n - 1});
        visited[0][n - 1] = true;
        int[] ret = null;
        for (int i = 1; i <= k; i++) {
            ret = priorityQueue.poll();
            if (ret[0] + 1 <= ret[1] && !visited[ret[0] + 1][ret[1]]) {
                visited[ret[0] + 1][ret[1]] = true;
                priorityQueue.offer(new int[]{ret[0] + 1, ret[1]});
            }
            if (ret[1] - 1 >= ret[0] && !visited[ret[0]][ret[1] - 1]) {
                visited[ret[0]][ret[1] - 1] = true;
                priorityQueue.offer(new int[]{ret[0], ret[1] - 1});
            }
        }
        return new int[]{arr[ret[0]], arr[ret[1]]};
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while (true) {
            double mid = (left + right) / 2;
            int i = -1, count = 0;
            // 记录最大的分数
            int x = 0, y = 1;

            for (int j = 1; j < n; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }

            if (count == k) {
                return new int[]{x, y};
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }


    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
        double l = 0.0, r = 1.0;
        int n = arr.length;
        int x = 0, y = 1;
        while (true) {
            double mid = (l + r) / 2;
            int cnt = 0;
            int i = -1;
            for (int j = 1; j < n; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                cnt += i + 1;
            }
            if (cnt == k) {
                return new int[]{x, y};
            } else if (cnt < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }


}
