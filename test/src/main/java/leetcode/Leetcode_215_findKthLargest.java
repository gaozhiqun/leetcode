package leetcode;


import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_215_findKthLargest {

    public static void main(String[] args) {
        Leetcode_215_findKthLargest l = new Leetcode_215_findKthLargest();
    }

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : nums) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

}