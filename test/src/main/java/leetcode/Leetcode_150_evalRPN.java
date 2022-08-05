package leetcode;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_150_evalRPN {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        Leetcode_150_evalRPN l = new Leetcode_150_evalRPN();
        System.out.println(l.evalRPN(tokens));
        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(l.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        stack.push(op2 * op1);
                        break;
                    case "/":
                        stack.push(op2 / op1);
                        break;
                    default:
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }


}