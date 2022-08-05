package algorithm.niuke;

import algorithm.tree.TreeNode;

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/17 下午2:50
 */
public class Permutation {
    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        permutation.perm("abcdef".toCharArray(), 0, 5);
        System.out.println(permutation.maxWater(new int[]{
                3, 1, 2, 5, 2, 4
        }));
        System.out.println(permutation.maxWater(new int[]{
                4, 5, 1, 3, 2
        }));
    }


    public void dfs(ArrayList<String> ret, char[] chars, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chars.length) {
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; ++i) {
            if (visited[i]) {
                continue;
            }
            sb.append(chars[i]);
            visited[i] = true;
            dfs(ret, chars, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public ArrayList<String> permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[str.length()];
        dfs(ret, chars, new StringBuilder(), visited);
        return ret;
    }


    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }


    public long maxWater(int[] arr) {
        // write code here
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (stack.isEmpty() || arr[i] < arr[stack.peek()]) {
                stack.push(i);
            } else {
                int max = 0;
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    int cur = stack.pop();
                    max = arr[cur];
                    if (!stack.isEmpty()) {
                        ret += (Math.min(arr[stack.peek()], arr[i]) - max) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return ret;
    }

    // NLR LNR
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode node = reConstructBinaryTree(xianxu, zhongxu);
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (i == size - 1) {
                    ret.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        int[] arr = new int[ret.size()];
        for (int i = 0; i < ret.size(); ++i) {
            arr[i] = ret.get(i);
        }
        return arr;
    }

    //前序遍历和中序遍历结果 NLR LNR
    // 0, 1, 2, 3, 4, 5, 6, 7     0, 1, 2, 3, 4, 5, 6, 7
    // 1, 2, 4, 7, 3, 5, 6, 8     4, 7, 2, 1, 5, 3, 8, 6
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0) {
            return null;
        }
        return build(pre, 0, vin, 0, vin.length - 1);
    }

    private TreeNode build(int[] pre, int i, int[] vin, int l, int r) {
        TreeNode node = new TreeNode(pre[i]);
        if (l == r) {
            return node;
        }
        int k = l;
        while (pre[i] != vin[k]) {
            ++k;
        }
        if (k == l) {
            node.right = build(pre, i + 1, vin, k + 1, r);
        } else if (k == r) {
            node.left = build(pre, i + 1, vin, l, k - 1);
        } else {
            node.right = build(pre, i + k - l + 1, vin, k + 1, r);
            node.left = build(pre, i + 1, vin, l, k - 1);
        }
        return node;
    }

    public int solve(char[][] grid) {
        // write code here
        int ret = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++ret;
                    bfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        grid[i][j] = '0';
        for (int d = 0; d < 4; ++d) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];
            if (ni >= 0 && nj >= 0
                    && ni < grid.length && nj < grid[0].length
                    && grid[ni][nj] == '1') {
                bfs(grid, ni, nj);
            }
        }
    }


    private int count;

    // 全排列获取方法1 固定位置找排序
    public void perm(char[] arr, int start, int end) {
        if (start == end) {
            count++;
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                perm(arr, start + 1, end);
                swap(arr, i, start);
            }
        }
    }

}