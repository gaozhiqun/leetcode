package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_132_cloneGraph {

    public static void main(String[] args) {
        Leetcode_132_cloneGraph l = new Leetcode_132_cloneGraph();

    }

    Map<Integer, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        Node cloneNode = cloneMap.get(node.val);
        if (cloneNode == null) {
            cloneNode = new Node(node.val);
            cloneMap.put(node.val, cloneNode);
            cloneNode.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
        }
        return cloneNode;
    }


    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}