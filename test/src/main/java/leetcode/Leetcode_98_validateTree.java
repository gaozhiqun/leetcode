package leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_98_validateTree {

    /**
     * 10[0,0,1,2,3,3,4,7,7,8]
     * 3
     * 5
     */

    public static void main(String[] args) {
        Leetcode_98_validateTree l = new Leetcode_98_validateTree();
        System.out.println(l.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
        System.out.println(l.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
        System.out.println(l.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(l.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node3.left = node4;
        System.out.println(l.printTree(node1));
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        LinkedList<Integer> minOrder = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode l = stack.pop();
            if (!minOrder.isEmpty() && l.val <= minOrder.peekLast()) {
                return false;
            }
            minOrder.addLast(l.val);
            cur = l.right;
        }
        return true;
    }


    Map<String, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(node);
        }
        return serial;
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


    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildNode(nums, 0, nums.length - 1);
    }

    private TreeNode buildNode(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = nums[l];
        int maxi = l;
        for (int i = l; i <= r; ++i) {
            if (nums[i] > max) {
                maxi = i;
                max = nums[i];
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildNode(nums, l, maxi - 1);
        node.right = buildNode(nums, maxi + 1, r);
        return node;
    }

    int ret;
    Map<Integer, Integer> map;


    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        ret = 0;
        dfs(root, 0, 0);
        return ret;
    }

    private void dfs(TreeNode cur, int depth, int pos) {
        if (cur == null) {
            return;
        }
        int l = map.computeIfAbsent(depth, f -> pos);
        ret = Math.max(ret, pos - l + 1);
        dfs(cur.left, depth + 1, 2 * pos);
        dfs(cur.left, depth + 1, 2 * pos + 1);
    }


    public List<List<String>> printTree(TreeNode root) {
        int maxDepth = getDepth(root);
        if (maxDepth == 0) {
            return new ArrayList<>();
        }
        int len = (1 << maxDepth) - 1;
        String[][] values = new String[maxDepth][len];
        for (int i = 0; i < maxDepth; ++i) {
            Arrays.fill(values[i], "");
        }
        assignValue(values, 0, root, 0, len - 1);
        List<List<String>> ret = new ArrayList<>();
        for (String[] value : values) {
            ret.add(Arrays.asList(value));
        }
        return ret;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private void assignValue(String[][] values, int depth, TreeNode cur, int l, int r) {
        if (l > r || cur == null) {
            return;
        }
        int mid = l + (r - l) / 2;
        String[] value = values[depth];
        value[mid] = String.valueOf(cur.val);
        assignValue(values, depth + 1, cur.left, l, mid - 1);
        assignValue(values, depth + 1, cur.right, mid + 1, r);
    }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    ++y;
                    break;
                case 'D':
                    --y;
                    break;
                case 'L':
                    --x;
                    break;
                case 'R':
                    ++x;
                    break;
            }

        }
        return x == 0 && y == 0;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a, b) -> a.equals(b)
                ? a - b : Math.abs(a - x) - Math.abs(b - x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cntsMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> endsMap = new HashMap<Integer, Integer>();
        for (int x : nums) {
            cntsMap.put(x, cntsMap.getOrDefault(x, 0) + 1);
        }
        for (int x : nums) {
            int cnt = cntsMap.getOrDefault(x, 0);
            if (cnt > 0) {
                cntsMap.put(x, cnt - 1);
                if (endsMap.getOrDefault(x - 1, 0) > 0) {
                    endsMap.put(x - 1, endsMap.getOrDefault(x - 1, 0) - 1);
                    endsMap.put(x, endsMap.getOrDefault(x, 0) + 1);
                } else {
                    int cnt1 = cntsMap.getOrDefault(x + 1, 0);
                    int cnt2 = cntsMap.getOrDefault(x + 2, 0);
                    if (cnt1 > 0 && cnt2 > 0) {
                        cntsMap.put(x + 1, cnt1 - 1);
                        cntsMap.put(x + 2, cnt2 - 1);
                        endsMap.put(x + 2, endsMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
