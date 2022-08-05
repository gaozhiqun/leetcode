package algorithm.offer;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/9 3:18 下午
 */
public class LevelOrder {

    public static void main(String[] args) {

    }

    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            resultList.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return resultList;
    }
}

