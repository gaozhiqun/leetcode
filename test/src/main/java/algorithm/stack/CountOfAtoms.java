package algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/7 下午6:07
 */
public class CountOfAtoms {
    public static void main(String[] args) {

    }

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int i = 0, m = formula.length();
        while (i < m) {
            char ch = formula.charAt(i);
            if (ch == ')') {
                int num = getNum(formula, i + 1);
                Map<String, Integer> curMap = stack.pop();
                Map<String, Integer> preMap = stack.peek();
                for (Map.Entry<String, Integer> entry : curMap.entrySet()) {
                    preMap.put(entry.getKey(), preMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * num);
                }
            } else if (ch == '(') {
                i++;
                stack.push(new HashMap<>());
            } else if (Character.isUpperCase(ch)) {
                String atom = getNextAtom(formula, ++i);
                int num = getNum(formula, ++i);
                Map<String, Integer> curMap = stack.peek();
                curMap.put(atom, curMap.getOrDefault(atom, 0) + num);
            }
        }
        Map<String, Integer> preMap = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(preMap);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();


    }


    private String getNextAtom(String formula, int from) {
        while (!Character.isUpperCase(formula.charAt(from))) {
            ++from;
        }
        int end = from + 1;
        while (end < formula.length() && Character.isLowerCase(formula.charAt(end))) {
            ++end;
        }
        return formula.substring(from, end);
    }

    private int getNum(String formula, int from) {
        int result = 0;
        while (!Character.isLowerCase(formula.charAt(from))) {
            ++from;
        }
        while (from++ < formula.length() && Character.isDigit(formula.charAt(from))) {
            result = result * 10 + from - '0';
        }
        return result == 0 ? 1 : result;
    }
}
