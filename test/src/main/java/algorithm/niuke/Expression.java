package algorithm.niuke;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/20 下午4:47
 */
public class Expression {

    Map<Character, Integer> priorityMap;
    Deque<Integer> nums;
    Deque<Character> ops;

    private int slove(String s) {
        int n = s.length();
        nums = new LinkedList<>();
        ops = new LinkedList<>();
        priorityMap = new HashMap<>();
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            char c = chars[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else if (isDigit(c)) {
                int u = 0, j = i;
                while (j < n && isDigit(chars[j])) {
                    u = u * 10 + (chars[j++] - '0');
                }
                nums.addLast(u);
                i = j - 1;
            } else {
                while (!ops.isEmpty() && ops.peekLast() != '('
                        && priorityMap.get(ops.peekLast()) >= priorityMap.get(c)) {
                        cal(nums, ops);
                }
                ops.addLast(c);
            }
        }
        while (!ops.isEmpty() && ops.getLast() != ')') {
            cal(nums, ops);
        }
        return nums.peekLast();
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.size() < 2 || ops.isEmpty()) {
            return;
        }
        int a = nums.pollLast(), b = nums.pollLast();
        char op = ops.pollLast();
        int ret = 0;
        switch (op) {
            case '+':
                ret = a + b;
                break;
            case '-':
                ret = b - a;
                break;
            case '*':
                ret = a * b;
                break;
            case '/':
                ret = b / a;
        }
        nums.addLast(ret);
    }

    public static void main(String[] args) {
        Expression expression = new Expression();
        System.out.println(expression.slove("(2*(3-4))*5"));


    }
}
