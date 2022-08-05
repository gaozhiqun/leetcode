package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/12 上午10:26
 */
public class Leetcode_726_countOfAtoms {

    public static void main(String[] args) {
        Leetcode_726_countOfAtoms l = new Leetcode_726_countOfAtoms();
        System.out.println(l.countOfAtoms("Be32"));
        System.out.println(l.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(l.countOfAtoms("Mg(OH)2"));
        System.out.println(l.countOfAtoms("H2O"));
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> cnts = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(cnts);
        int i = 0;
        while (i < formula.length()) {
            char cur = formula.charAt(i);
            if (cur == ')') {
                i++;
                String digitValue = getDigit(formula, i);
                int digit;
                if ("".equals(digitValue)) {
                    digit = 1;
                } else {
                    i += digitValue.length();
                    digit = Integer.parseInt(digitValue);
                }
                merge(stack.pop(), stack.peek(), digit);
            } else if (cur == '(') {
                stack.push(new HashMap<>());
                i++;
            } else {
                String atom = getNextAtom(formula, i);
                i += atom.length();
                String digitValue = getDigit(formula, i);
                int digit;
                if ("".equals(digitValue)) {
                    digit = 1;
                } else {
                    i += digitValue.length();
                    digit = Integer.parseInt(digitValue);
                }
                stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + digit);
            }

        }
        StringBuilder ret = new StringBuilder();
        for (Map.Entry<String, Integer> entry : cnts.entrySet()) {
            ret.append(entry.getKey());
            if (entry.getValue() > 1) {
                ret.append(entry.getValue());
            }
        }
        return ret.toString();
    }

    private void merge(Map<String, Integer> b, Map<String, Integer> a, int cnt) {
        for (Map.Entry<String, Integer> entry : b.entrySet()) {
            a.put(entry.getKey(), a.getOrDefault(entry.getKey(), 0) + entry.getValue() * cnt);
        }
    }


    private String getNextAtom(String s, int l) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = l;
        if (Character.isUpperCase(s.charAt(i))) {
            stringBuilder.append(s.charAt(i++));
        }
        while (i < s.length() && Character.isLowerCase(s.charAt(i))) {
            stringBuilder.append(s.charAt(i++));
        }
        return stringBuilder.toString();
    }

    private String getDigit(String s, int l) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = l;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            stringBuilder.append(s.charAt(i++));
        }
        return stringBuilder.toString();
    }
}

