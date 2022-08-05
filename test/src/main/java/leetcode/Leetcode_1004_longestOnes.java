package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/4/1 下午6:57
 */
public class Leetcode_1004_longestOnes {
    public static void main(String[] args) {
        Leetcode_1004_longestOnes l = new Leetcode_1004_longestOnes();
        TreeNode nod = l.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(nod);
        System.out.println(l.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(l.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

    }


    public int longestOnes(int[] nums, int k) {
        int N = nums.length;
        int l = 0, r = 0, len = 0, cnt = 0, ret = 0;
        while (r < N) {
            len++;
            if (nums[r] == 0) {
                cnt++;
            }
            while (cnt > k) {
                len--;
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }
            ret = Math.max(len, ret);
            ++r;
        }
        return ret;
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        return buildNode(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildNode(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = preorder[l];
        TreeNode node = new TreeNode(val);
        ++l;
        int mid = l;
        while (mid <= r && preorder[mid] < val) {
            ++mid;
        }
        node.left = buildNode(preorder, l, mid - 1);
        node.right = buildNode(preorder, mid, r);
        return node;
    }




}
