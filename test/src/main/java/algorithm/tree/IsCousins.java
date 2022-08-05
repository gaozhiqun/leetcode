package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/28 下午4:40
 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean foundX = false, foundY = false;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode next = queue.poll();
                if (next.left != null && next.right != null &&
                        (next.left.val == x && next.right.val == y || next.left.val == y && next.right.val == x)) {
                    return false;
                }
                if (next.val == x) {
                    foundX = true;
                }
                if (next.val == y) {
                    foundY = true;
                }
            }
            if (foundX && foundY) {
                return true;
            }
        }
        return false;

    }
}
