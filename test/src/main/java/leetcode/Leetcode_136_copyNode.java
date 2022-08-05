package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_136_copyNode {

    public static void main(String[] args) {
        Leetcode_136_copyNode l = new Leetcode_136_copyNode();
        /**
         * gas  = [1,2,3,4,5]
         * cost = [3,4,5,1,2]
         */

    }

    Map<Node, Node> nodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = nodeMap.get(head.val);
        if (node == null) {
            node = new Node(head.val);
            nodeMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return node;
    }


    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}