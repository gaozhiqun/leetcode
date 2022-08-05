package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/25 下午7:39
 */
public class FlipMatchVoyage {
    public static void main(String[] args) {

    }

    /**
     * NLR 验证前序
     *
     * @param root
     * @param voyage
     * @return
     */

    private List<Integer> ans;
    private int curIndex;
    private int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        curIndex = 0;
        this.voyage = voyage;
        dfs(root);
        if (!ans.isEmpty() && ans.get(0) == -1) {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        if (cur.val != voyage[curIndex++]) {
            ans.clear();
            ans.add(-1);
            return;
        }
        if (curIndex < voyage.length && cur.left != null && cur.left.val != voyage[curIndex]) {
            ans.add(cur.val);
            dfs(cur.right);
            dfs(cur.left);
        } else {
            dfs(cur.left);
            dfs(cur.right);
        }
    }

}
