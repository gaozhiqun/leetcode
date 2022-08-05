package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_589_preorder {

    /**
     * 方法 2：Graham 扫描 [Accepted]
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode_589_preorder leetcode_560_subarraySum = new Leetcode_589_preorder();
    }

    //NLR
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.pollLast();
            ans.add(cur.val);
            List<Node> children = cur.children;
            if (children != null && children.size() > 0) {
                for (int j = children.size() - 1; j >= 0; --j) {
                    queue.add(children.get(j));
                }
            }
        }
        return ans;
    }

    //RLN
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeLast();
            res.addFirst(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.addLast(node.children.get(i));
            }
        }
        return res;
    }


    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public String fractionAddition(String expression) {
        List < Character > sign = new ArrayList < > ();
        if (expression.charAt(0) != '-')
            sign.add('+');
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        }
        int prev_num = 0, prev_den = 1, i = 0;
        for (String sub: expression.split("(\\+)|(-)")) {
            if (sub.length() > 0) {
                String[] fraction = sub.split("/");
                int num = (Integer.parseInt(fraction[0]));
                int den = (Integer.parseInt(fraction[1]));
                int g = Math.abs(gcd(den, prev_den));
                if (sign.get(i++) == '+')
                    prev_num = prev_num * den / g + num * prev_den / g;
                else
                    prev_num = prev_num * den / g - num * prev_den / g;
                prev_den = den * prev_den / g;
                g = Math.abs(gcd(prev_den, prev_num));
                prev_num /= g;
                prev_den /= g;
            }
        }
        return prev_num + "/" + prev_den;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}