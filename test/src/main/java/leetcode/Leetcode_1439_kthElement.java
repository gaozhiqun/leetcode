package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 下午4:02
 */
public class Leetcode_1439_kthElement {
    /**
     * [-3,-6,-8,-4,-2,-8,-6,0,0,0,0]
     * [5,4,3,2,4,7,6,1,7]
     * [6,5,6,3,7,10,7,4,10]
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_1439_kthElement l = new Leetcode_1439_kthElement();
        System.out.println(l.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}));
//        System.out.println(l.kthSmallest(new int[][]{
//                {1, 10, 10}, {1, 4, 5}, {2, 3, 6}
//        }, 7));
        System.out.println(l.kthSmallest(new int[][]{
                {1, 1, 10}, {2, 2, 9}
        }, 7));
    }


    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        Set<String> seen = new HashSet<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return getSum(a, mat) - getSum(b, mat);
        });
        int[] seed = new int[m];
        int[] ret = new int[m];
        priorityQueue.offer(seed);
        seen.add(getCoded(seed));
        for (int i = 0; i < k; ++i) {
            ret = priorityQueue.poll();
            for (int j = 0; j < m; ++j) {
                int[] next = new int[m];
                System.arraycopy(ret, 0, next, 0, m);
                next[j]++;
                String coded = getCoded(next);
                if (next[j] < n && !seen.contains(coded)) {
                    priorityQueue.offer(next);
                    seen.add(coded);
                }
            }
        }
        return getSum(ret, mat);
    }

    private int getSum(int[] idex, int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; ++i) {
            sum += mat[i][idex[i]];
        }
        return sum;
    }

    private String getCoded(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            stringBuilder.append(i);
            stringBuilder.append("=");
            stringBuilder.append(arr[i]);
            stringBuilder.append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


    public int minSetSize(int[] arr) {
        Map<Integer, Integer> cntsMap = new HashMap<>();
        for (int i : arr) {
            cntsMap.put(i, cntsMap.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(cntsMap.entrySet());
        Collections.sort(entryList, (a, b) -> {
            return b.getValue() - a.getValue();
        });
        int c = 0, i = 0;
        while (c < arr.length / 2) {
            c += entryList.get(i++).getValue();
        }
        return i;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = nums.length;
        List<Boolean> ret = new ArrayList<>();
        for (int o = 0; o < l.length; o++) {
            int i = l[o];
            int j = r[o];
            ret.add(checkArray(nums, i, j));
        }
        return ret;
    }

    public boolean checkArray(int[] nums, int l, int r) {
        int min = nums[l], max = nums[l], sum = 0;
        int n = r - l + 1;
        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; ++i) {
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int gap = (max - min) / (n - 1);
        while (min < max) {
            if (!set.contains(min)) {
                return false;
            }
            min += gap;
        }
        return true;
    }


    public int singleNonDuplicate(int[] nums) {
        int m = nums.length;
        if (m == 1 || nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[m - 1] != nums[m - 2]) {
            return nums[m - 1];
        }
        for (int i = 1; i < m - 1; ++i) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;

    }

    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i : changed) {
            cntMap.put(i, cntMap.getOrDefault(i, 0) + 1);
        }
        for (int i : changed) {
            if (!cntMap.containsKey(i)) {
                continue;
            }
            int p = 2 * i;
            if (!cntMap.containsKey(p)) {
                return new int[0];
            }
            if (i != 0) {
                ret.add(i);
                int ic = cntMap.get(i) - 1;
                int pc = cntMap.get(p) - 1;
                if (ic == 0) {
                    cntMap.remove(i);
                } else {
                    cntMap.put(i, ic);
                }
                if (pc == 0) {
                    cntMap.remove(p);
                } else {
                    cntMap.put(p, pc);
                }
            } else {
                int ic = cntMap.get(i) - 2;
                if (ic >= 0) {
                    ret.add(0);
                    if (ic == 0) {
                        cntMap.remove(0);
                    } else {
                        cntMap.put(0, ic);
                    }
                } else {
                    return new int[0];
                }
            }

        }
        if (!cntMap.isEmpty()) {
            return new int[0];
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); ++i) {
            res[i] = ret.get(i);
        }
        return res;
    }


    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (arr[mid] > arr[r]) {
                if (arr[l] <= target && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r--;
            }
        }
        return -1;
    }

    //1. 计算以max为最大值的覆盖范围
    //2. 计算以min为最大值的覆盖范围
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int m = differences.length;
        int gap = upper - lower;
        int min = 0, max = 0;
        int[] relativeArr = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            relativeArr[i + 1] = relativeArr[i] + differences[i];
            min = Math.min(relativeArr[i + 1], min);
            max = Math.max(relativeArr[i + 1], max);
            if (max - min > gap) {
                return 0;
            }
        }
        return Math.max(gap - max + min + 1, 0);

    }


    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] maxs = new int[len];
        int[] mins = new int[len];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            maxs[i] = max;
            max = Math.max(max, nums[i]);
        }
        int min = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            mins[i] = min;
            min = Math.min(min, nums[i]);
        }
        int ans = 0;
        for (int i = 1; i < mins.length - 1; i++) {
            int num = nums[i];
            if (num > maxs[i] && num < mins[i]) {
                ans += 2;
            } else if (num > nums[i - 1] && num < nums[i + 1]) {
                ans += 1;
            }
        }
        return ans;
    }


}
