package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/18 下午7:07
 */
public class AllPossibleFBT {
    public static void main(String[] args) {

    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            TreeNode node = new TreeNode(0);
            result.add(node);
            return result;
        }
        n--;
        for (int k = 1; k < n; k += 2) {
            List<TreeNode> lCandidates = allPossibleFBT(k);
            List<TreeNode> rCadidates = allPossibleFBT(n - k);
            for (TreeNode l : lCandidates) {
                for (TreeNode r : rCadidates) {
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                }
            }
        }
        return result;
    }

}
