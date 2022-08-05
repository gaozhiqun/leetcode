package algorithm.offer;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/6/9 8:06 下午
 */
public class VerifyPostOrder {

    public static void main(String[] args) {
        VerifyPostOrder verifyPostOrder = new VerifyPostOrder();
        System.out.println(verifyPostOrder.verifyPostOrder2(new int[]{1, 3, 2, 6, 5}));
        System.out.println(verifyPostOrder.verifyPostOrder2(new int[]{1, 6, 3, 2, 5}));
    }

    public boolean verifyPostOrder2(int[] postOrder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postOrder.length - 1; i >= 0; i--) {
            if (postOrder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postOrder[i]) { //把比它大的节点pop出来，最后一个就是该节点的parent
                root = stack.pop();
            }
            stack.add(postOrder[i]);
        }
        return true;
    }

    public boolean verifyPostOrder(int[] postOrder) {
        return helper(0, postOrder.length - 1, postOrder);
    }

    private boolean helper(int l, int r, int[] postOrder) {
        if (l == r) {
            return true;
        }
        int poviet = postOrder[r];
        int cur = l;
        while (postOrder[cur] < poviet) {
            cur++;
        }
        for (int i = cur; i < r; i++) {
            if (postOrder[i] < poviet) {
                return false;
            }
        }
        if (cur == l || cur == r) {
            return helper(l, r - 1, postOrder);
        }
        return helper(l, cur - 1, postOrder) && helper(cur, r - 1, postOrder);
    }
}
