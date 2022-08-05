package algorithm.niuke;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/17 上午11:48
 */
public class MinStack {


    public class Solution {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            map.put(node, map.getOrDefault(node, 0) + 1);
        }

        public void pop() {
            int val = stack.pop();
            int cnts = map.get(val);
            --cnts;
            if (cnts == 0) {
                map.remove(val);
            } else {
                map.put(val, cnts);
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return map.firstKey();
        }
    }
}
