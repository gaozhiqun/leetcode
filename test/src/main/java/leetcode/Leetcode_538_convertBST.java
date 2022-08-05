package leetcode;


import algorithm.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_538_convertBST {


    public static void main(String[] args) {
        Leetcode_538_convertBST l = new Leetcode_538_convertBST();
        System.out.println(l.maximumSwap(2736));
        System.out.println(l.maximumSwap(9973));
        System.out.println(l.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(l.findMinDifference(Arrays.asList("23:56", "00:00")));
        System.out.println(l.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.right);
        sum += cur.val;
        cur.val = sum;
        dfs(cur.left);
    }

    public int findMinDifference(List<String> timePoints) {
        int s = getTime(timePoints.get(0));
        int e = getTime(timePoints.get(1));
        return Math.min(e - s, 3600 + s - e);
    }

    private int getTime(String timePoint) {
        String[] time = timePoint.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

    public int singleNonDuplicate(int[] nums) {
        int m = nums.length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     * 最多删除一个字符
     */
    public boolean validPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            ++l;
            --r;
        }
        return isValid(s, l + 1, r) || isValid(s, l, r - 1);
    }

    public boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public int calPoints(String[] ops) {
        LinkedList<String> o = new LinkedList<>();
        int ret = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    o.pollLast();
                    break;
                case "D":
                    o.addLast(String.valueOf(getDigit(o.peekLast()) * 2));
                    break;
                case "+":
                    String first = o.pollLast();
                    String second = o.peekLast();
                    o.addLast(first);
                    o.addLast(String.valueOf(getDigit(first) + getDigit(second)));
                    break;
                default:
                    o.addLast(op);
            }
        }
        while (!o.isEmpty()) {
            ret += getDigit(o.pollFirst());
        }
        return ret;
    }

    private int getDigit(String s) {
        return Integer.parseInt(s);
    }

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ret = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ret.add(sum / size);
        }
        return ret;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode trimLeft = trimBST(root.left, low, high);
        TreeNode trimRight = trimBST(root.right, low, high);
        if (root.val < low) {
            return trimRight;
        } else if (root.val > high) {
            return trimLeft;
        } else {
            root.left = trimLeft;
            root.right = trimRight;
            return root;
        }
    }

    public int maximumSwap(int num) {
        String nString = String.valueOf(num);
        char[] ans = nString.toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < nString.length(); i++) {
            last[ans[i] - '0'] = i;
        }
        for (int i = 0; i < nString.length(); i++) {
            for (int d = 9; d > nString.charAt(i) - '0'; d--) {
                if (last[d] > i) {
                    swap(ans, i, last[d]);
                    return Integer.parseInt(new String(ans));
                }
            }
        }
        return num;
    }

    private void swap(char[] ans, int i, int j) {
        char temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }

    /**
     *
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left != null && root.left.val > root.val) {
            return root.left.val;
        }
        if (root.right != null && root.right.val > root.val) {
            return root.right.val;
        }
        int l = findSecondMinimumValue(root.left);
        int r = findSecondMinimumValue(root.right);
        return l == -1 ? r : r == -1 ? l : Math.min(l, r);
    }

    /**
     * 将所有灯泡的状态反转（即开变为关，关变为开）
     * 将编号为偶数的灯泡的状态反转
     * 将编号为奇数的灯泡的状态反转
     * 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
     * n 只灯泡可能有多少种不同的状态
     * Light 1 = 1 + a + c + d
     * Light 2 = 1 + a + b
     * Light 3 = 1 + a + c
     * Light 4 = 1 + a + b + d
     * Light 5 = 1 + a + c
     * Light 6 = 1 + a + b
     */

    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) return 1;
        if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }


}