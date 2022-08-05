package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_320_MaxNum {

    public static void main(String[] args) {
        Leetcode_320_MaxNum l = new Leetcode_320_MaxNum();
        int[] ans = l.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(" ");
        ans = l.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(" ");
        ans = l.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3);
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 单调栈不可以，贪心算法
     *
     * @return
     */

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] a = maxSubsequence(nums1, i);
            int[] b = maxSubsequence(nums2, k - i);
            int[] temp = merge(a, b);
            if (compare(temp, 0, ans, 0) > 0) {
                System.arraycopy(temp, 0, ans, 0, k);
            }
        }
        return ans;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }

}