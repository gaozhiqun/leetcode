package algorithm.niuke;

import algorithm.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/18 下午4:18
 */
public class Medium {

    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        // write code here
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return 0;
        }
        int l1 = 0, l2 = 0, r1 = arr1.length - 1, r2 = arr2.length - 1;
        while (l1 < r1) {
            int mid1 = l1 + (r1 - l1) / 2;
            int mid2 = l2 + (r2 - l2) / 2;
            int offset = ((r1 - l1 + 1) & 1) ^ 1; //奇数还是偶数

            if (arr1[mid1] > arr2[mid2]) {
                r1 = mid1;
                l2 = mid2 + offset;
            } else if (arr1[mid1] < arr2[mid2]) {
                r2 = mid2;
                l1 = mid1 + offset;
            } else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[l1], arr2[l2]);
    }


    public boolean[] judgeIt(TreeNode root) {
        // write code here
        return new boolean[]{isSearch(root, Long.MIN_VALUE, Long.MAX_VALUE), isComplete(root)};
    }

    private boolean isSearch(TreeNode cur, long left, long right) {
        if (cur == null) {
            return true;
        }
        if (cur.val <= left || cur.val >= right) {
            return false;
        }
        return isSearch(cur.left, left, cur.val) && isSearch(cur.right, cur.val, right);

    }

    private boolean isComplete(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode left = null;
        TreeNode right = null;
        boolean flag = false;
        while(!queue.isEmpty()){
            root = queue.poll();
            left = root.left;
            right = root.right;
            //遇到左右孩子不双全的节点并且该节点不是叶子节点的时候就不是完全二叉树  //左孩子为空并且右孩子不为空的时候不是完全二叉树
            if((flag && !(left == null && right == null)) || (left == null && right != null)){
                return false;
            }
            if(left != null)    queue.offer(left);
            if(right != null)   queue.offer(right);
            if(left == null || right == null)   flag = true;
        }
        return true;
    }


}
