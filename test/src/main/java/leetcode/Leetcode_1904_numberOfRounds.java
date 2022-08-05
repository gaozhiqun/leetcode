package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 下午12:09
 */
public class Leetcode_1904_numberOfRounds {

    public static void main(String[] args) {
        Leetcode_1904_numberOfRounds l = new Leetcode_1904_numberOfRounds();
        System.out.println(l.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(l.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

    public int numberOfRounds(String loginTime, String logoutTime) {
        int a = convert(loginTime);
        int b = convert(logoutTime);
        if (b < a) {
            b += 24 * 60;
        }
        b /= 15;
        a = a % 15 == 0 ? a / 15 : (a / 15 + 1);
        return Math.max(b - a, 0);
    }


    private int convert(String time) {
        String[] splits = time.split(":");
        return Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
    }


    public String largestOddNumber(String num) {
        String ret = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : num.toCharArray()) {
            stringBuilder.append(ch);
            if (((ch - '0') & 1) != 0) {
                ret = stringBuilder.toString();
            }
        }
        return ret;

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }


    public int[] rearrangeArray(int[] nums) {
        int m = nums.length;
        int[] pos = new int[m / 2];
        int[] ne = new int[m / 2];
        int[] ret = new int[m];
        int ai = 0, aj = 0;
        for (int i = 0; i < m; ++i) {
            if (nums[i] > 0) {
                pos[ai++] = nums[i];
            } else {
                ne[aj++] = nums[i];
            }
        }
        for (int i = 0; i < m / 2; ++i) {
            ret[2 * i] = pos[i];
            ret[2 * i + 1] = ne[i];
        }
        return ret;
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int idx = 0;
        for (int i : arr2) {
            idxMap.put(i, idx++);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        list.sort((a, b) -> {
            if (idxMap.containsKey(a)) {
                return idxMap.containsKey(b) ? idxMap.get(a) - idxMap.get(b) : -1;
            } else if (idxMap.containsKey(b)) {
                return 1;
            } else {
                return a - b;
            }
        });
        for (int i = 0; i < list.size(); ++i) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int m = nums.length;
        int[] lsums = new int[m + 1];
        int[] rsums = new int[m + 1];
        for (int i = 1; i <= m; ++i) {
            lsums[i] = lsums[i - 1] + nums[i - 1];
            rsums[m - i] = rsums[m + 1 - i] + nums[m - i];
        }
        int[] ret = new int[m];
        for (int i = 0; i < m; ++i) {
            ret[i] = nums[i] * (2 * i - m + 1) - lsums[i] + rsums[i + 1];
        }
        return ret;
    }


    public int[] constructArr(int[] a) {
        int m = a.length;
        int[] lmulti = new int[m + 1];
        int[] rmulti = new int[m + 1];
        lmulti[0] = 1;
        rmulti[m] = 1;
        for (int i = 1; i <= m; ++i) {
            lmulti[i] = lmulti[i - 1] * a[i - 1];
            rmulti[m - i] = rmulti[m + 1 - i] * a[m - i];
        }
        int[] ret = new int[m];
        for (int i = 0; i < m; ++i) {
            ret[i] = lmulti[i] * rmulti[i + 1];
        }
        return ret;
    }


    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> idexMap = new HashMap<>();
        int idx = 0;
        for (int i : nums) {
            idexMap.put(i, idx++);
        }
        for (int[] op : operations) {
            idx = idexMap.get(op[0]);
            nums[idx] = op[1];
            idexMap.remove(op[0]);
            idexMap.put(op[1], idx);
        }
        return nums;

    }

    public List<Integer> intersection(int[][] nums) {
        Set<Integer> aSet = new HashSet<>();
        for (int i : nums[0]) {
            aSet.add(i);
        }
        for (int i = 1; i < nums.length; ++i) {
            Set<Integer> bSet = new HashSet<>();
            for (int j : nums[i]) {
                bSet.add(j);
            }
            Set<Integer> temp = new HashSet<>();
            for (int a : aSet) {
                if (bSet.contains(a)) {
                    temp.add(a);
                }
            }
            aSet = temp;
            if (aSet.size() == 0) {
                return new ArrayList<>();
            }
        }
        List<Integer> ret = new ArrayList<>(aSet);
        Collections.sort(ret);
        return ret;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length, n = queries.length;
        int[] xors = new int[m + 1];
        int[] ret = new int[n];
        for (int i = 1; i <= m; ++i) {
            xors[i] = xors[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            int l = queries[i][0], r = queries[i][1];
            ret[i] = xors[r + 1] ^ xors[l];
        }
        return ret;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int m = nums.length;
        int[] ret = new int[m];
        int l = 0, r = m - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < pivot) {
                ret[l++] = nums[i];
            }
            if (nums[m - 1 - i] > pivot) {
                ret[r--] = nums[m - 1 - i];
            }
        }
        for (int i = l; i <= r; ++i) {
            ret[i] = pivot;
        }
        return ret;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> pos = new LinkedList<>();
        pos.addLast(-1);//占位
        int ret = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & 1) != 0) {
                pos.addLast(i);
                if (pos.size() > k) {
                    int first = pos.pollFirst();
                    int lc = pos.peekFirst() - first;
                    int r = i + 1;
                    while (r < nums.length && (nums[r] & 1) == 0) {
                        ++r;
                    }
                    ret += lc * (r - i);
                    i = r - 1;
                }
            }
        }
        return ret;
    }

}
