package algorithm.niuke;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/16 下午3:09
 */
public class LowestCommonAncestor {
    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        traversal(root, o1, list1);
        traversal(root, o2, list2);
        while (list1.size() > list2.size()) {
            list1.poll();
        }
        while (list2.size() > list1.size()) {
            list2.poll();
        }
        int ret = -1;
        while (!list1.isEmpty()) {
            TreeNode node1 = list1.poll();
            TreeNode node2 = list2.poll();
            if (node1 == node2) {
                return node1.val;
            }
        }
        return ret;
    }

    private boolean traversal(TreeNode root, int v, LinkedList<TreeNode> list) {
        if (root == null) {
            return false;
        } else if (root.val == v) {
            list.add(root);
            return true;
        }
        if (traversal(root.left, v, list)
                || traversal(root.right, v, list)) {
            list.add(root);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.search(new int[]{6, 8, 10, 0, 2, 4}, 10));
        System.out.println(lowestCommonAncestor.search(new int[]{6, 8, 10, 0, 2, 4}, 3));
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        // 定义四个指针，并且充当边界限制的作用
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right - 1; top != bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; left != right && i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }


    public int Fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int getLongestPalindrome(String A) {
        // write code here
        int ret = 1;
        for (int i = 1; i < A.length(); ++i) {
            ret = Math.max(extend(A, i, i), ret);
            ret = Math.max(extend(A, i - 1, i), ret);
        }
        return ret;
    }

    private int extend(String A, int l, int r) {
        int ret = 0;
        while (l >= 0 && r < A.length()
                && A.charAt(l) == A.charAt(r)) {
            ret = Math.max(r - l + 1, ret);
            --l;
            ++r;
        }
        return ret;
    }

    // a+b+c=0
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int m = num.length;
        if (m < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        if (num[0] > 0 || num[m - 1] < 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < m - 2; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int k = m - 1;
            for (int j = i + 1; j < k && (num[i] + num[j] <= 0); ++j) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                while (num[i] + num[j] + num[k] > 0 && k > j + 1) {
                    --k;
                }
                if (num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> truple = new ArrayList<>();
                    truple.add(num[i]);
                    truple.add(num[j]);
                    truple.add(num[k]);
                    ret.add(truple);
                }
            }
        }
        return ret;
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

    public int[] LIS(int[] arr) {
        int m = arr.length;
        int[] mins = new int[m];
        int[] lens = new int[m];
        lens[0] = 1;
        mins[0] = arr[0];
        int idx = 0;
        for (int i = 1; i < m; ++i) {
            if (arr[i] > mins[idx]) {
                mins[++idx] = arr[i];
                lens[i] = idx + 1;
            } else {
                int l = 0, r = idx;
                while (l <= r) {
                    int mid = (r + l) / 2;
                    if (mins[mid] >= arr[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                mins[l] = arr[i];
                lens[i] = l + 1;
            }
        }
        int[] ret = new int[idx + 1];
        for (int i = lens.length - 1; i >= 0; --i) {
            if (lens[i] == idx + 1) {
                ret[idx--] = arr[i];
            }
        }
        return ret;
    }

    public int sqrt(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }

        int l = 1, r = x;
        while (true) {
            int mid = (l + r) >> 1;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return (int) mid;
            } else if (mid < x / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    public int search(int[] nums, int target) {
        // write code here
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        if (nums[l] == target) {
            return l;
        } else if (nums[r] == target) {
            return r;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[l] > nums[mid] && nums[r] > nums[mid]
                || nums[l] < nums[mid] && nums[r] < nums[mid]) {
            int findL = search(nums, l, mid - 1, target);
            if (findL > 0) {
                return findL;
            } else {
                return search(nums, mid + 1, r, target);
            }
        } else if (nums[l] < nums[mid] && nums[mid] < nums[r]) {
            if (nums[mid] < target) {
                return search(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid - 1, target);
            }
        }
        return -1;
    }


}
