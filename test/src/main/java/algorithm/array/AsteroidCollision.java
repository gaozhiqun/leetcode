package algorithm.array;

import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/9 下午8:18
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println(asteroidCollision.asteroidCollision(new int[]{5, 10, -5}));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int o : asteroids) {
            if (o > 0) {
                while (!stack.isEmpty() && stack.peek() < 0 && stack.peek() + o > 0) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() + o > 0) {
                    stack.push(o);
                }
            }
            if (o < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + o < 0) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() + o < 0) {
                    stack.push(o);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i > -1; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
