package algorithm;

import algorithm.tree.TreeNode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/2/23 下午5:14
 */
public class ListNodeMap {

    public static class ListNode {
        ListNode pre;
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private Map<Integer, ListNode> map = new HashMap<>();
    ListNode head, tail;
    int size;

    private ListNode getN(int n) {
        if (n > size) {
            throw new IllegalArgumentException();
        }
        ListNode cur = head;
        for (int i = 0; i < n; ++i) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode unLink(int val) {
        ListNode cur = map.get(val);
        if (cur == null) {
            return cur;
        }
        ListNode pre = cur.pre;
        ListNode next = cur.next;
        if (pre == null) {
            head = next;
        } else {
            pre.next = cur.next;
        }

        if (tail == null) {
            tail = cur.pre;
        } else {
            next.pre = pre;
        }
        cur.pre = null;
        cur.next = null;
        --size;
        return cur;
    }

    public void insert(ListNode node, int pos) {
        map.put(node.val, node);
        if (pos == 0) {
            node.next = head;
            head = node;
        } else if (pos == size) {
            tail.next = node;
            tail = node;
        } else {
            ListNode cur = head;
            for (int i = 0; i < pos - 1; ++i) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next.pre = node;
            cur.next = node;
            node.pre = cur;
        }
        ++size;
    }


    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur1 = list1, cur2 = list2;
        ListNode cur = dummyHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return dummyHead.next;
    }

    public ListNode partition(ListNode head, int x) {
        // write code here
        ListNode list1 = new ListNode(-1);
        ListNode list2 = new ListNode(-1);
        ListNode cur1 = list1, cur2 = list2;
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = next;
        }
        cur1.next = list2.next;
        return list1.next;
    }

    /**
     * 1,4,3,2,5,2
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNodeMap listNodeMap = new ListNodeMap();
        System.out.println(listNodeMap.solve("114514", ""));
        int[] A = new int[]{4, 5, 6, 0, 0, 0};
        listNodeMap.merge(A, 3, new int[]{1, 2, 3}, 3);
        System.out.println(A);
        System.out.println(listNodeMap.maxLength(new int[]{2, 3, 4, 5}));
        System.out.println(listNodeMap.maxLength(new int[]{1, 2, 3, 1, 2, 3, 2, 2}));
        System.out.println(listNodeMap.maxLength(new int[]{2, 2, 3, 4, 8, 99, 3}));
        System.out.println(listNodeMap.FindGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9}));
//        ListNode nodev1 = new ListNode(1);
//        ListNode nodev2 = new ListNode(2);
//        ListNode nodev3 = new ListNode(3);
//        ListNode nodev4 = new ListNode(4);
//        ListNode nodev5 = new ListNode(5);
//        nodev1.next = nodev2;
//        nodev2.next = nodev3;
//        nodev3.next = nodev4;
//        nodev4.next = nodev5;
//        ListNode ret = listNodeMap.reverseKGroup(nodev1, 2);
//
//        System.out.println(listNodeMap.FindNumsAppearOnce(new int[]{1, 2, 3, 3, 2, 9}));
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        ListNode node = listNodeMap.partition(node1, 3);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
    }

    /**
     * a^b
     *
     * @param array
     * @return
     */


    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int a = 0, b = 0, c = 0;
        for (int i : array) {
            a ^= i;
        }
        int mask = 1;
        for (int i = 0; i < 31; ++i) {
            mask = mask << i;
            if ((a & mask) != 0) {
                break;
            }
        }
        for (int i : array) {
            if ((i & mask) == 0) {
                b ^= i;
            } else {
                c ^= i;
            }
        }
        return new int[]{Math.min(b, c), Math.max(b, c)};
    }


    public long solve(int[] A) {
        // write code here
        Arrays.sort(A);
        int n = A.length;
        return Math.max((long) A[0] * A[1] * A[n - 1],
                (long) A[n - 3] * A[n - 2] * A[n - 1]);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, tail;
        outter:
        while (true) {
            tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    break outter;
                }
            }
            ListNode[] pair = reverse(pre.next, tail);
            pre.next = pair[0];
            pre = pair[1];
        }
        return dummyHead.next;
        // write code here
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head, fianlTail = tail.next;
        while (cur != fianlTail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0, ret = Integer.MIN_VALUE;
        for (int i : array) {
            sum += i;
            ret = Math.max(sum, ret);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ret;
    }

    public int maxLength(int[] arr) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int l = -1, ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            int n = arr[i];
            int lastShow = map.getOrDefault(n, -1);
            l = Math.max(l, lastShow);
            ret = Math.max(ret, i - l);
            map.put(n, i);
        }
        return ret;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public ListNode EntryNodeOfLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        if (j >= 0) {
            System.arraycopy(B, 0, A, 0, j + 1);
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tail = dummyHead, pre = dummyHead;
        for (int i = 0; i < n; ++i) {
            tail = tail.next;
            if (tail == null) {
                return head;
            }
        }
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;
        return dummyHead.next;
    }

    public String solve(String s, String t) {
        // write code here
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int digit = carry
                    + ((i >= 0) ? (s.charAt(i--) - '0') : 0)
                    + ((j >= 0) ? (t.charAt(j--) - '0') : 0);
            carry = digit / 10;
            ans.append(digit % 10);
        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        int level = 0;
        while (!stack.isEmpty()) {
            Stack<TreeNode> newStack = new Stack<>();
            ArrayList<Integer> levelRet = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (level % 2 == 0) {
                    if (cur.left != null) {
                        newStack.push(cur.left);
                    }
                    if (cur.right != null) {
                        newStack.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        newStack.push(cur.right);
                    }
                    if (cur.left != null) {
                        newStack.push(cur.left);
                    }
                }
                ++level;
                levelRet.add(cur.val);
            }
            ret.add(levelRet);
            stack = newStack;
        }
        return ret;
    }


    public ListNode sortInList(ListNode head) {
        // write code here
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        for (ListNode node : nodes) {
            node.next = null;
            pre.next = node;
            pre = pre.next;
        }
        return dummyHead.next;
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int ld = getDepth(root.left), rd = getDepth(root.right);
        if (Math.abs(ld - rd) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    public int minPathSum(int[][] matrix) {
        // write code here
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    /**
     * (2*(3-4))*5 =  1*(2*(3-4))*5
     *
     * @param s
     * @return
     */



}



