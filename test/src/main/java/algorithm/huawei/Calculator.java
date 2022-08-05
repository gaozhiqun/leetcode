package algorithm.huawei;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午2:32
 */
public class Calculator {
    public static void main(String[] args) {
        //System.out.println(cal("3-10+(0+(10+5+3)-10)"));
        //System.out.println(cal("(7+5*4*3+6)"));
        //System.out.println(cal("3+2*{1+2*[-4/(8-6)+7]}"));
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(cal(in.nextLine()));
        }
    }


    public static int cal(String s) {
        LinkedList<Integer> digits = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('(', 0);
        map.put('[', 0);
        map.put('{', 0);
        map.put('*', 1);
        map.put('/', 1);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = getDigit(i, s);
                i += String.valueOf(digit).length() - 1;
                digits.addLast(digit);
            } else if (ch == '(' || ch == '{' || ch == '[') {
                ops.addLast(ch);
            } else if (ch == '}') {
                while (!ops.isEmpty() && ops.peekLast() != '{') {
                    cal(digits, ops);
                }
                ops.pollLast();
            } else if (ch == ']') {
                while (!ops.isEmpty() && ops.peekLast() != '[') {
                    cal(digits, ops);
                }
                ops.pollLast();
            } else if (ch == ')') {
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    cal(digits, ops);
                }
                ops.pollLast();
            } else if (ch == '-' && (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '[' || s.charAt(i - 1) == '{')) {
                ++i;
                int digit = -getDigit(i, s);
                i += String.valueOf(digit).length() - 2;
                digits.addLast(digit);
            } else {
                while (!ops.isEmpty()
                        && ops.peekLast() != '(' && ops.peekLast() != '[' && ops.peekLast() != '{'
                        && map.get(ops.peekLast()) >= map.get(ch)) {
                    cal(digits, ops);
                }
                ops.addLast(ch);
            }
        }
        while (!ops.isEmpty()) {
            cal(digits, ops);
        }
        return digits.pollLast();
    }


    private static int getDigit(int i, String s) {
        int val = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            val = val * 10 + (s.charAt(i++) - '0');
        }
        return val;
    }

    private static void cal(LinkedList<Integer> digits, LinkedList<Character> ops) {
        if (digits.size() < 2 || ops.isEmpty()) {
            return;
        }
        int b = digits.pollLast();
        int a = digits.pollLast();
        char ch = ops.pollLast();
        if (ch == '+') {
            digits.addLast(a + b);
        } else if (ch == '-') {
            digits.addLast(a - b);
        } else if (ch == '*') {
            digits.addLast(a * b);
        } else if (ch == '/') {
            digits.addLast(a / b);
        }
    }
}
