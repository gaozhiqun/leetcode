package algorithm.tree;

import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午5:21
 */
public class ConstructFromPrePost {
    public static void main(String[] args) {

    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(postorder[0]);
        int L = 0;
        for (int i = 0; i < n; ++i) {
            if (postorder[i] == preorder[1]) {
                L = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, L + 1),
                Arrays.copyOfRange(preorder, 0, L));

        root.right = constructFromPrePost(Arrays.copyOfRange(preorder, L + 1, n),
                Arrays.copyOfRange(preorder, L, n - 1));

        return root;
    }

    private TreeNode buildRecursive(int[] preorder, int[] postorder, int i, int j) {
        TreeNode cur = new TreeNode(preorder[i]);
        for (int nextPre = i + 1; nextPre < preorder.length; ++nextPre) {
            for (int nextPost = j - 1; nextPost >= 0; --nextPost) {
                if (preorder[nextPre] == postorder[nextPost]) {
                    if (cur.left == null) {
                        cur.left = buildRecursive(preorder, postorder, nextPre, nextPost);
                    }
                }
            }
        }
        return cur;
    }
}
