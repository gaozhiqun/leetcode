package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_124_maxPathSum {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = Math.max(0, maxSum(cur.left));
        int r = Math.max(0, maxSum(cur.right));
        maxSum = Math.max(cur.val + l + r, maxSum);
        return cur.val + Math.max(l, r);
    }


    public boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && isSymmetric(a.left, b.right) &&
                isSymmetric(a.right, b.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (reverse) {
                Collections.reverse(list);
            }
            ans.add(list);
            reverse = !reverse;
        }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * NLR LNR
     * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    private TreeNode buildNode(int[] preOrder, int[] inorder, int i, int l, int r) {
        if (i < 0 || i >= preOrder.length || l > r) {
            return null;
        }
        int rootValue = preOrder[i];
        int j = l;
        while (j <= r) {
            if (inorder[j] == rootValue) {
                break;
            }
            ++j;
        }
        int llen = j - l;
        TreeNode node = new TreeNode(rootValue);
        node.left = buildNode(preOrder, inorder, i + 1, l, j - 1);
        node.right = buildNode(preOrder, inorder, i + 1 + llen, j + 1, r);
        return node;
    }

    public static void main(String[] args) {

        Leetcode_124_maxPathSum l = new Leetcode_124_maxPathSum();
        TreeNode ans = l.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(ans);

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        l.flatten(root);
        System.out.println(root);
    }


    /**
     * 中序遍历 inorder = [9,3,15,20,7] LNR
     * 后序遍历 postorder = [9,15,7,20,3] LRN
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        int m = inorder.length;
        TreeNode root = new TreeNode(postorder[m - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = m - 1;
        for (int i = m - 2; i >= 0; --i) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    --inorderIndex;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildNode(nums, l, mid - 1);
        node.right = buildNode(nums, mid + 1, r);
        return node;
    }

    boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return balance;
    }

    private int getDepth(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int l = getDepth(cur.left);
        int r = getDepth(cur.right);
        if (Math.abs(l - r) > 1) {
            balance = false;
        }
        return 1 + Math.max(l, r);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null
                && root.right == null
                && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, ans, temp);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(temp));
        }
        dfs(root.left, targetSum, ans, temp);
        dfs(root.right, targetSum, ans, temp);
        temp.remove(temp.size() - 1);
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = root;
        TreeNode lpart = helper(root.left);
        TreeNode rpart = helper(root.right);
        root.left = null;
        head.right = lpart;
        while (head.right != null) {
            head = head.right;
        }
        head.right = rpart;
        return root;
    }

}
