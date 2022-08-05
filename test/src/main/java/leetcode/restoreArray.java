package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/28 下午9:24
 */
public class restoreArray {
    public static void main(String[] args) {
        restoreArray restoreArray = new restoreArray();
        System.out.println(restoreArray.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }


    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length;
        if (m == 1) {
            return adjacentPairs[0];
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> nbs = new HashMap<>();
        for (int[] p : adjacentPairs) {
            nbs.computeIfAbsent(p[0], f -> new ArrayList<>()).add(p[1]);
            nbs.computeIfAbsent(p[1], f -> new ArrayList<>()).add(p[0]);
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] seed = adjacentPairs[0];
        linkedList.addLast(seed[0]);
        linkedList.addLast(seed[1]);
        visited.add(seed[0]);
        visited.add(seed[1]);
        dfs(linkedList, true, visited, nbs);
        dfs(linkedList, false, visited, nbs);
        int[] ret = new int[m + 1];
        int i = 0;
        while (!linkedList.isEmpty()) {
            ret[i++] = linkedList.poll();
        }
        return ret;
    }

    private void dfs(LinkedList<Integer> list, boolean dir, Set<Integer> visited, Map<Integer, List<Integer>> nbs) {
        int cur;
        if (dir) {
            cur = list.peekFirst();
        } else {
            cur = list.peekLast();
        }
        for (int n : nbs.get(cur)) {
            if (visited.contains(n)) {
                continue;
            }
            visited.add(n);
            if (dir) {
                list.addFirst(n);
            } else {
                list.addLast(n);
            }
            dfs(list, dir, visited, nbs);
        }
    }


    public boolean canChoose(int[][] gs, int[] nums) {
        int n = nums.length, m = gs.length;
        int cnt = 0;
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (check(gs[j], nums, i)) {
                i += gs[j++].length;
                cnt++;
            } else {
                i++;
            }
        }
        return cnt == m;
    }

    boolean check(int[] g, int[] nums, int i) {
        int j = 0;
        for (; j < g.length && i < nums.length; j++, i++) {
            if (g[j] != nums[i]) return false;
        }
        return j == g.length;
    }

    public int[] getAverages(int[] nums, int k) {
        int m = nums.length;
        int[] ret = new int[m];
        Arrays.fill(ret, -1);
        if (m < 2 * k + 1) {
            return ret;
        }
        long sums = 0;
        for (int i = 0; i < m; ++i) {
            sums += nums[i];
            if (i > k - 1) {
                sums -= nums[i - k];
            }
            if (i > 2 * k) {
                ret[i - k - 1] = (int) (sums) / (2 * k + 1);
            }

        }
        return ret;
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();
        for (int i : nums) {
            cnts.put(i, cnts.getOrDefault(i, 0) + 1);
        }
        while (!cnts.isEmpty()) {
            int min = cnts.firstKey();
            for (int i = 0; i < k; ++i) {
                int cnt = cnts.getOrDefault(min + i, 0);
                if (cnt == 0) {
                    return false;
                }
                --cnt;
                if (cnt == 0) {
                    cnts.remove(min + i);
                } else {
                    cnts.put(min + i, cnt);
                }
            }
        }
        return true;
    }


    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_001;
        int ret = 0;
        int m = arr.length;
        List<Integer> posList = new ArrayList<>();
        posList.add(-1);//leftBoarder
        for (int i = 0; i < arr.length; ++i) {
            if ((arr[i] & 1) == 0) {
                continue;
            }
            posList.add(i);
        }
        posList.add(m);
        for (int i = 1; i < posList.size() - 1; ++i) {
            int pre = posList.get(i) - posList.get(i - 1);
            int after = 0;
            for (int j = i; (j + 1) < posList.size(); j += 2) {
                after += posList.get(j + 1) - posList.get(j);
            }
            ret += (pre * after) % mod;
            ret %= mod;
        }
        return ret;
    }

    public int numOFSubarrays(int[] arr) {
        final int mod = 1000000007;
        int odd = 0, even = 1;
        int sum = 0, ret = 0;
        for (int i : arr) {
            sum += i;
            ret = (ret + (sum % 2 == 0 ? odd : even)) % mod;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return ret;
    }

    public int getWinner(int[] arr, int k) {
        int m = arr.length;
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        } else if (k >= (m - 1)) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int cnt = 0, max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            int cur = arr[i];
            if (cur > max) {
                max = cur;
                cnt = 1;
            } else {
                ++cnt;
                if (cnt >= k) {
                    return max;
                }
            }
        }
        return -1;
    }

    /**
     * always remember remove duplicate
     *
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        long offset = 0, base = k;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] <= base) {
                offset += (++base) - nums[i];
            }
        }
        return offset + ((long) k) * (1 + k) / 2;
    }

    public boolean canReach(int[] arr, int start) {
        int m = arr.length;
        Boolean[] canReach = new Boolean[m];
        boolean[] visited = new boolean[m];
        return canReach(arr, visited, canReach, start);
    }

    private boolean canReach(int[] arr, boolean[] visited, Boolean[] canReach, int cur) {
        if (canReach[cur] != null) {
            return canReach[cur];
        }
        visited[cur] = true;
        if (arr[cur] == 0) {
            return canReach[cur] = true;
        }
        boolean ret = false;
        if (cur >= arr[cur] && !visited[cur - arr[cur]]) {
            ret = canReach(arr, visited, canReach, cur - arr[cur]);
        }
        if (cur + arr[cur] < arr.length && !visited[cur + arr[cur]]) {
            ret = ret || canReach(arr, visited, canReach, cur + arr[cur]);
        }
        visited[cur] = false;
        return ret;
    }


}
