package segmentTree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/1 下午4:27
 */
public class LeeCoin {

    public static void main(String[] args) {
        LeeCoin l = new LeeCoin();
        int[] ans = l.bonus(6, new int[][]{
                {1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}
        }, new int[][]{
                {1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}
        });
        for (int i : ans) {
            System.out.println(i);
        }
    }

    /**
     * 将所有人的编号映射到 [1, N][1,N] 的区间，其中负责人及其团队需要映射到一段连续的区间
     * 能通过负责人的编号获取得到其团队的区间 [l, r][l,r]。
     */

    int mod = 1000_000_007;

    int id = 1;


    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        List<Integer>[] slaves = new List[n + 1];
        int[] begins = new int[n + 1];
        int[] ends = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            slaves[i] = new ArrayList<>();
        }
        for (int[] lead : leadership) {
            slaves[lead[0]].add(lead[1]);
        }
        dfs(1, begins, ends, slaves);
        List<Integer> ans = new ArrayList<>();
        BIT bit = new BIT(n);
        for (int[] op : operations) {
            if (op[0] == 1) {
                bit.updateInterval(ends[op[1]], ends[op[1]], op[2]);
            } else if (op[0] == 2) {
                bit.updateInterval(begins[op[1]], ends[op[1]], op[2]);
            } else {
                ans.add((bit.querySlavesInterval(begins[op[1]], ends[op[1]]) % mod + mod) % mod);
            }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    private void dfs(int i, int[] begins, int[] ends, List<Integer>[] slaves) {
        begins[i] = id;
        for (int slave : slaves[i]) {
            dfs(slave, begins, ends, slaves);
        }
        ends[i] = id;
        id++;
    }

    class BIT {
        // 记录∑di i->(1,r)
        private long[] tree;
        // 记录∑(i-1)*di i->(1,r)
        private long[] ntimTree;
        // a1+a2+...+ar=r*∑di-∑(i-1)*di 结果
        private int n;

        public BIT(int n) {
            this.n = n;
            this.tree = new long[n + 1];
            this.ntimTree = new long[n + 1];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x, int val) {
            int k = x;
            while (x <= n) {
                tree[x] += val;
                ntimTree[x] += val * (k - 1);
                x += lowbit(x);
            }
        }

        public void updateInterval(int l, int r, int val) {
            update(l, val);
            update(r + 1, -val);
        }

        public int query(int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= lowbit(x);
            }
            return ret;
        }

        private int querySlaves(int pos) {
            long ret = 0, x = pos;
            while (pos != 0) {
                ret += x * tree[pos] % mod - ntimTree[pos] % mod;
                pos -= lowbit(pos);
            }
            return (int) (ret % mod);
        }

        private int querySlavesInterval(int l, int r) {
            return querySlaves(r) - querySlaves(l - 1);
        }

    }
}