package algorithm.binary;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/1 上午10:33
 */
public class binarySearch {


    private int findOnlyOne(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid + 1;
            }
        }
        return -1;
    }


    //第一个相等
    public int binarySearchFirstEq(int[] value, int target) {
        int low = 0;
        int high = value.length - 1;

        while (low <= high) {
            if (value[low] == target) {
                return low;
            }
            int mid = low + ((high - low) >> 1);
            if (value[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
                low++;
            }
        }
        return -1;
    }


    // >=target
    private int firstGreater(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }
                r = mid - 1;
            }
        }
        return l;
    }

    // <=target
    private int firstSmaller(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return l;
    }

    //最后一次出现的定值
    private int findLastSeen(int[] arr, int target) {
        int low = 0;
        int len = arr.length;
        int high = len - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == len - 1 || arr[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 旋转数组最小值
     */

    public int minSpineArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (arr[l] < arr[r]) {
                return arr[l];
            }
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else if (arr[mid] == arr[r]) { //mid==r
                r = r - 1;
            } else {
                r = mid;
            }
        }
        return arr[l];
    }


    //不知道二分点情况
    public static int bsearch1(int[] value, int target) {

        int low = 0;
        int high = value.length - 1;
        int first = value[0];
        if (target == first) {
            return 0;
        }
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (value[mid] == target) {
                return mid;
            }
            if (value[mid] > target) {
                //因为是循环数组, 比二分点小的数, 有可能在右边
                //比二分点小的数在右边需要满足: 1,二分点位于左边部分的数组, 2,target位于右边部分的数组
                //以[4,5,6,7,1,2,3]为例, mid属于4567, target属于123
                if (value[mid] > first && target < first) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                //因为是循环有序数组, 有可能在左边
                //同理, 要满足: 1,二分点位于右边部分的数组, 2,target位于左边部分的数组
                if (value[mid] < first && target > first) {
                    //在左边
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        if (value[low] == target) return low;
        return -1;
    }


    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len + 1];
        int sum = 0;
        for (int i = len - 1; i >= 0; --i) {
            sum += piles[i];
            for (int M = 1; M <= len; ++M) {
                if (i + M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; ++x) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }


    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : arr) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });
        for (Map.Entry entry : cnts.entrySet()) {
            priorityQueue.offer(entry);
        }
        while (k > 0) {
            if (k < priorityQueue.peek().getValue()) {
                break;
            }
            k -= priorityQueue.poll().getValue();
        }
        return priorityQueue.size();


    }
}
