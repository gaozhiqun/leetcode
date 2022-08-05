package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_735_asteroidCollision {

    public static void main(String[] args) {
        Leetcode_735_asteroidCollision l = new Leetcode_735_asteroidCollision();
    }


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }


}