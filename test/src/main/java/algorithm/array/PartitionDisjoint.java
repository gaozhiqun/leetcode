package algorithm.array;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/19 下午6:49
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        PartitionDisjoint partitionDisjoint = new PartitionDisjoint();
        System.out.println(partitionDisjoint.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(partitionDisjoint.partitionDisjoint(new int[]{5, 4, 3, 2, 1}));
    }

    public int partitionDisjoint(int[] A) {
        int m = A.length;
        int[] mins = new int[m];
        int[] maxs = new int[m];
        maxs[0] = A[0];
        mins[m - 1] = A[m - 1];
        for (int i = 1; i < m; ++i) {
            maxs[i] = Math.max(A[i], maxs[i - 1]);
            mins[m - 1 - i] = Math.min(A[m - 1 - i], mins[m - i]);
        }
        int ans = 1;
        while (ans < m - 1 && maxs[ans - 1] > mins[ans]) {
            ++ans;
        }
        return ans;
    }
}
