package segmentTree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/1 下午2:18
 */
public class CreateSortedArray {

    public static void main(String[] args) {
        CreateSortedArray createSortedArray = new CreateSortedArray();
        System.out.println(createSortedArray.createSortedArray(new int[]{
                1, 5, 6, 2
        }));
        System.out.println(createSortedArray.createSortedArray(new int[]{
                1, 2, 3, 6, 5, 4
        }));
        System.out.println(createSortedArray.createSortedArray(new int[]{
                1, 3, 3, 3, 2, 4, 2, 1, 2
        }));
    }

    int mod = 1000_000_007;

    /**
     * min(2, 1)
     * 总最小代价 10^9 + 7
     *
     * @return
     */
    public int createSortedArray(int[] instructions) {
        int ans = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : instructions) {
            treeSet.add(i);
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int idx = 0;
        for (int n : treeSet) {
            indexMap.put(n, idx++);
        }
        int m = treeSet.size();
        int[] tree = new int[m + 1];
        for (int i : instructions) {
            idx = indexMap.get(i) + 1;
            ans += Math.min(query(tree, idx - 1),
                    query(tree, m) - query(tree, idx));
            ans %= mod;
            update(tree, m, idx);
        }
        return ans;
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int[] tree, int m, int x) {
        while (x <= m) {
            tree[x]++;
            x += lowBit(x);
        }
    }

    private int query(int[] tree, int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowBit(x);
        }
        return ans;
    }

}
