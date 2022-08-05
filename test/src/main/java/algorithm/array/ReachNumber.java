package algorithm.array;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/14 下午4:17
 */
public class ReachNumber {
    public static void main(String[] args) {
        ReachNumber reachNumber = new ReachNumber();
        System.out.println(reachNumber.reachNumber(3));
    }

    /**
     * 终止条件是什么？
     *
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        int cur = 1;
        while (true) {
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                int p = stack.pop();
                if (p == target) {
                    return cur - 1;
                }
                if (!seen.contains(cur + p)) {
                    seen.add(cur + p);
                    stack.push(cur + p);
                } else if (!seen.contains(p - cur)) {
                    seen.add(p - cur);
                    stack.push(p - cur);
                }
            }
            cur++;
        }
    }

}
