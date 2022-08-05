package leetcode;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/24 下午7:19
 */
public class Leetcode_950_deckRevealedIncreasing {
    public static void main(String[] args) {

    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i) {
            index.add(i);
        }
        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }
        return ans;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val &&
                (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                        || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
