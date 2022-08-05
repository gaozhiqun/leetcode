package leetcode;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_480_mediumOfSlidingWindow {

    public static void main(String[] args) {
        Leetcode_480_mediumOfSlidingWindow l = new Leetcode_480_mediumOfSlidingWindow();
    }

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int minHeapSize, maxHeapSize, size;
    Map<Integer, Integer> lazyMap;


    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ret = new double[n - k + 1];
        for (int i = 0; i < k; ++i) {
            add(nums[i]);
            if (n >= k - 1) {
                int m = nums[n - k + 1];
                remove(m);
                ret[n - k + 1] = getMedium();
            }
        }
        return ret;
    }

    private double getMedium() {
        makeBalance();
        if (size % 2 == 0) {
            return ((double) minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }

    private void add(int n) {
        if (minHeap.isEmpty() || n > minHeap.peek()) {
            maxHeap.offer(n);
            maxHeapSize++;
        } else {
            minHeap.offer(n);
            minHeapSize++;
        }
        makeBalance();
        size++;
    }

    private void remove(int n) {
        lazyMap.put(n, lazyMap.getOrDefault(n, 0) + 1);
        if (minHeap.isEmpty() || n <= minHeap.peek()) {
            minHeapSize--;
            purge();
        } else {
            maxHeapSize--;
            purge();
        }
        makeBalance();
        size--;
    }

    private void purge() {
        while (!minHeap.isEmpty() && lazyMap.containsKey(minHeap.peek())) {
            int num = minHeap.poll();
            int cnt = lazyMap.get(num) - 1;
            if (cnt == 0) {
                lazyMap.remove(num);
            } else {
                lazyMap.put(num, cnt);
            }
            --minHeapSize;
        }

        while (!maxHeap.isEmpty() && lazyMap.containsKey(maxHeap.peek())) {
            int num = maxHeap.poll();
            int cnt = lazyMap.get(num) - 1;
            if (cnt == 0) {
                lazyMap.remove(num);
            } else {
                lazyMap.put(num, cnt);
            }
            --maxHeapSize;
        }
    }

    private void makeBalance() {
        while (minHeapSize < maxHeapSize) {
            purge();
            minHeap.offer(maxHeap.poll());
            minHeapSize++;
            maxHeapSize--;
        }
        while (minHeapSize > maxHeapSize + 1) {
            purge();
            maxHeap.offer(minHeap.poll());
            minHeapSize--;
            maxHeapSize++;
        }
    }


}
