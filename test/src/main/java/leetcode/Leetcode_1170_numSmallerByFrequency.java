package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/6 下午8:28
 */
public class Leetcode_1170_numSmallerByFrequency {
    public static void main(String[] args) {
        Leetcode_1170_numSmallerByFrequency l = new Leetcode_1170_numSmallerByFrequency();
        int[] ret = l.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"});
        ret = l.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
    }


    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return f(o1) - f(o2);
            }
        });
        int[] ret = new int[queries.length];
        int idx = 0;
        for (String q : queries) {
            ret[idx++] = firstGreater(words, q);
        }
        return ret;
    }

    private int firstGreater(String[] words, String query) {
        int m = f(query);
        int l = 0, r = words.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (f(words[mid]) <= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return words.length - l;
    }


    private int f(String s) {
        int[] cnts = new int[26];
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnts[i] > 0) {
                return cnts[i];
            }
        }
        return 0;
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long sum = Long.MIN_VALUE;
        int level = 0, ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long curSum = 0;
            ++level;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                curSum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (curSum > sum) {
                sum = curSum;
                ret = level;
            }
        }
        return ret;
    }


}
