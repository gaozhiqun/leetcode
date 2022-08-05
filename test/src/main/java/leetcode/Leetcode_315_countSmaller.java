package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_315_countSmaller {

    public static void main(String[] args) {

    }

    int[] ans;
    int[] index;
    int[] temp;
    int[] tempIndex;

    public List<Integer> countSmaller2(int[] nums) {
        int n = nums.length;
        ans = new int[n];
        index = new int[n];
        temp = new int[n];
        tempIndex = new int[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        mergeSort(nums, 0, n - 1);
        List<Integer> list = new ArrayList<Integer>();
        for (int num : ans) {
            list.add(num);
        }
        return list;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, p = l;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[p] = nums[i];
                tempIndex[p] = index[i];
                ans[index[i]] += (j - mid - 1);
                ++i;
                ++p;
            } else {
                temp[p] = nums[j];
                tempIndex[p] = index[j];
                ++j;
                ++p;
            }
        }
        while (i <= mid) {
            temp[p] = nums[i];
            tempIndex[p] = index[i];
            ans[index[i]] += (j - mid - 1);
            ++i;
            ++p;
        }
        while (j <= r) {
            temp[p] = nums[j];
            tempIndex[p] = index[j];
            ++j;
            ++p;
        }
        for (int k = l; k <= r; ++k) {
            index[k] = tempIndex[k];
            nums[k] = temp[k];
        }
    }


    public static class Solution {
        private int[] c;
        private int[] a;

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> resultList = new ArrayList<Integer>();
            discretization(nums);
            init(nums.length + 5);
            for (int i = nums.length - 1; i >= 0; --i) {
                int id = getId(nums[i]);
                resultList.add(query(id - 1));
                update(id);
            }
            Collections.reverse(resultList);
            return resultList;
        }

        private void init(int length) {
            c = new int[length];
            Arrays.fill(c, 0);
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        private void update(int pos) {
            while (pos < c.length) {
                c[pos] += 1;
                pos += lowBit(pos);
            }
        }

        private int query(int pos) {
            int ret = 0;
            while (pos > 0) {
                ret += c[pos];
                pos -= lowBit(pos);
            }

            return ret;
        }

        private void discretization(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int size = set.size();
            a = new int[size];
            int index = 0;
            for (int num : set) {
                a[index++] = num;
            }
            Arrays.sort(a);
        }

        private int getId(int x) {
            return Arrays.binarySearch(a, x) + 1;
        }
    }


    int[] c;// index索引

    int[] a;   // 树状数组

    public List<Integer> countSmaller(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int size = set.size();
        Arrays.fill(c, 0);
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
        List<Integer> resultList = new ArrayList<>();
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;

    }

    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    private int lowBit(int x) {
        return x & (~x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }

    private int getId(int x) {
        return Arrays.binarySearch(c, x) - 1;
    }


}