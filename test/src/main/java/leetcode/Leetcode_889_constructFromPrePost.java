package leetcode;

import algorithm.tree.TreeNode;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/21 下午4:33
 */
public class Leetcode_889_constructFromPrePost {
    public static void main(String[] args) {
        Leetcode_889_constructFromPrePost l = new Leetcode_889_constructFromPrePost();
    }

    /**
     * NLR LRN
     *
     * @param preorder
     * @param postorder
     * @return
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int N = preorder.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (N == 1) {
            return root;
        }
        int L = 0;
        for (int i = 0; i < N; ++i) {
            if (postorder[i] == preorder[1]) {
                L = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, L + 1),
                Arrays.copyOfRange(postorder, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, L + 1, N),
                Arrays.copyOfRange(postorder, L, N - 1));
        return root;
    }

}
