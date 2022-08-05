package segmentTree;

import java.util.ArrayList;
import java.util.List;

public class Fancy {
    final long MOD = 1000000007;

    class Node {
        long a, b;

        public Node() {
            a = 1L;
            b = 0;
        }

        public Node(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public void add(Node node) {
            a = a * node.a % MOD;
            b = (b * node.a + node.b) % MOD;
        }
    }

    Node[] A = new Node[200000];
    List<Long> nums;

    public Fancy() {
        nums = new ArrayList();
        for (int i = 0; i < 200000; i++) {
            A[i] = new Node();
        }
    }

    public void append(int val) {
        nums.add(new Long(val));
    }

    public void addAll(int inc) {
        Node op = new Node(1L, new Long(inc));
        for (int i = 100000 - nums.size(); i < 200000; i += (i & -i)) {
            A[i].add(op);
        }
    }

    public void multAll(int m) {
        Node op = new Node(new Long(m), 0);
        for (int i = 100000 - nums.size(); i < 200000; i += (i & -i)) {
            A[i].add(op);
        }
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) {
            return -1;
        }
        Node op = new Node();
        for (int i = 100000 - (idx + 1); i >= 1; i -= (i & -i)) {
            op.add(A[i]);
        }
        return (int) ((op.a * nums.get(idx) + op.b) % MOD);
    }
}