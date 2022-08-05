package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/29 下午5:10
 */
public class MajorityChecker {
    public static void main(String[] args) {

        MajorityChecker majorityChecker = new MajorityChecker(new int[]{
                1, 1, 2, 2, 1, 1
        });
        System.out.println(majorityChecker.query(0, 5, 4));
        System.out.println(majorityChecker.query(0, 3, 3));
        System.out.println(majorityChecker.query(2, 3, 2));



    }

    /**
     * 2 * threshold > right - left + 1
     * remain + 2*deleted = r-l+1;
     * 2*remain + 2*deleted>=2*threshold;
     * remain>=2*threshold -(r-l+1)
     * 2*threshold- remain <=(r-l+1)
     */

    public int[] arr;

    int L, R;
    private Node root;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        L = 0;
        R = arr.length - 1;
        root = buildNode(L, R);
    }

    public int query(int left, int right, int threshold) {
        int[] ans = query(root, left, right);
        return 2 * threshold - ans[1] <= (right - left + 1) ? ans[0] : -1;
    }

    private int[] query(Node root, int l, int r) {
        if (l > root.end || r < root.start) {
            return new int[]{-1, 0};
        }
        if (root.start == l && root.end == r) {
            return new int[]{root.majority, root.cnts};
        }
        int mid = root.start + (root.end - root.start) / 2;
        int[] pre = query(root.left, l, Math.min(mid, r));
        int[] after = query(root.right, Math.max(mid + 1, l), r);
        return megre(pre, after);
    }

    private int[] megre(int[] pre, int[] after) {
        return new int[]{
                pre[0] == after[0] ? pre[0] : pre[1] == after[1] ? -1 : pre[1] > after[1] ? pre[0] : after[0],
                pre[0] == after[0] ? pre[1] + after[1] : Math.abs(pre[1] - after[1])
        };
    }


    public Node buildNode(int l, int r) {
        Node node = new Node(l, r);
        if (l == r) {
            node.cnts = 1;
            node.majority = arr[l];
            return node;
        }
        int mid = l + (r - l) / 2;
        node.left = buildNode(l, mid);
        node.right = buildNode(mid + 1, r);
        node.cnts = node.left.majority == node.right.majority ?
                node.left.cnts + node.right.cnts :
                Math.abs(node.left.cnts - node.right.cnts);
        node.majority = node.left.majority == node.right.majority ?
                node.left.majority : node.left.cnts == node.right.cnts ? -1 :
                node.left.cnts > node.right.cnts ?
                        node.left.majority : node.right.majority;
        return node;
    }

    public static class Node {
        int start, end, majority, cnts;
        Node left, right;

        public Node(int l, int r) {
            this.start = l;
            this.end = r;
            majority = -1;
            cnts = 0;
            left = null;
            right = null;
        }
    }




}
