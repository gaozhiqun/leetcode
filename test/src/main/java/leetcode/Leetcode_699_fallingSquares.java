package leetcode;

import algorithm.tree.TreeNode;
import segmentTree.CountRangeSum;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_699_fallingSquares {

    public static void main(String[] args) {
        Leetcode_699_fallingSquares l = new Leetcode_699_fallingSquares();
        System.out.println(l.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));

    }


    public List<Integer> fallingSquares(int[][] positions) {
        int[] qans = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            qans[i] += size;

            for (int j = i + 1; j < positions.length; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left2 < right && left < right2) { //intersect
                    qans[j] = Math.max(qans[j], qans[i]);
                }
            }
        }

        List<Integer> ans = new ArrayList();
        int cur = -1;
        for (int x : qans) {
            cur = Math.max(cur, x);
            ans.add(cur);
        }
        return ans;
    }

    public List<Integer> fallingSquares2(int[][] positions) {
        //Coordinate Compression
        Set<Integer> set = new TreeSet<>();
        for (int[] pos : positions) {
            set.add(pos[0]);
            set.add(pos[0] + pos[1] - 1);
        }
        int i = 0;
        HashMap<Integer, Integer> index = new HashMap<>();
        //离散化
        for (int m : set) {
            index.put(m, i++);
        }
        SegmentTree tree = new SegmentTree(set.size());
        int best = 0;
        List<Integer> ans = new ArrayList();

        for (int[] pos : positions) {
            int L = index.get(pos[0]);
            int R = index.get(pos[0] + pos[1] - 1);
            int h = tree.query(L, R) + pos[1]; //更新当前值，整个区间都是这个值
            tree.update(L, R, h);
            best = Math.max(best, h);
            ans.add(best);
        }
        return ans;
    }

    public static class SegmentTree {
        int N, H;
        int[] lazy; // 用时再更新父节点的值
        int[] tree;

        public SegmentTree(int n) {
            this.N = n;
            H = 1;
            while ((H << 1) < N) {
                ++H;
            }
            tree = new int[2 * N];
            lazy = new int[N];
        }

        // v 赋值给x
        public void apply(int x, int v) {
            tree[x] = Math.max(tree[x], v);
            if (x < N) {//父节点的值
                lazy[x] = Math.max(lazy[x], v);
            }
        }

        // 获取 x位置的值 自下而上而上传播，更新整个线段最大值
        public void pull(int x) {//自下而上传播，更新整个段最大值
            while (x > 1) {
                x >>= 1;
                tree[x] = Math.max(tree[x * 2], tree[x * 2 + 1]);
                tree[x] = Math.max(tree[x], lazy[x]); // 子节点的最大值或lazy值
            }
        }

        private void push(int x) {
            for (int h = H; h > 0; h--) { //自顶而下更新，把子区间更新为当前值
                int y = x >> h;//y==0时
                if (lazy[y] > 0) {
                    apply(y * 2, lazy[y]);
                    apply(y * 2 + 1, lazy[y]);
                    lazy[y] = 0;
                }
            }
        }

        public void update(int L, int R, int h) {
            L += N;
            R += N; //自下而上的更新
            int L0 = L, R0 = R, ans = 0;
            while (L <= R) {
                //保证始终为偶数
                if ((L & 1) == 1) {
                    apply(L++, h);
                }
                if ((R & 1) == 0) {
                    apply(R--, h);
                }
                L >>= 1;
                R >>= 1;
            }
            pull(L0);
            pull(R0);
        }

        public int query(int L, int R) {
            L += N;
            R += N;
            int ans = 0;
            push(L);
            push(R);
            while (L <= R) {
                if ((L & 1) == 1) {
                    ans = Math.max(ans, tree[L++]);
                }
                if ((R & 1) == 0) {
                    ans = Math.max(ans, tree[R--]);
                }
                L >>= 1;
                R >>= 1;
            }
            return ans;
        }

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }


    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    public int leastInterval(char[] tasks, int n) {
        int k = tasks.length;
        int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }
        int most = Arrays.stream(cnt).max().getAsInt();
        int mostCnt = 0;
        for (int i : cnt) {
            if (i == most) {
                ++mostCnt;
            }
        }
        return Math.max((most - 1) * (n + 1) + mostCnt, k);
    }
}