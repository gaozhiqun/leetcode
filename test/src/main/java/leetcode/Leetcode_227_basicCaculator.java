package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_227_basicCaculator {

    public static void main(String[] args) {
        Leetcode_227_basicCaculator l = new Leetcode_227_basicCaculator();
        System.out.println(l.calculate("3+2*2"));
        System.out.println(l.calculate("3/2"));
        System.out.println(l.calculate("3+5/2"));
        System.out.println(l.calculate(""));
    }

    public int calculate(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            if (stack.isEmpty()) {
                int[] nextNumber = getNextNumber(s, i);
                stack.push(nextNumber[1]);
                i = nextNumber[0];
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                int carry = 1;
                if (s.charAt(i) == '-') {
                    carry = -1;
                }
                ++i;
                int[] nextNumber = getNextNumber(s, i);
                stack.push(nextNumber[1] * carry);
                i = nextNumber[0];
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                boolean multiply = s.charAt(i) == '*';
                ++i;
                int[] nextNumber = getNextNumber(s, i);
                if (multiply) {
                    stack.push(nextNumber[1] * stack.pop());
                } else {
                    stack.push(stack.pop() / nextNumber[1]);
                }
                i = nextNumber[0];
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    int[] getNextNumber(String s, int i) {
        int ans = 0;
        int carry = 1;
        if (s.charAt(i) == '-') {
            ++i;
            carry = -1;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans *= 10;
            ans += (s.charAt(i) - '0');
            ++i;
        }
        return new int[]{i, ans * carry};
    }


    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        Map<String, Integer> cnts = new HashMap<>();
        for (String s : strings) {
            cnts.put(s, cnts.getOrDefault(s, 0) + 1);
        }
        k = Math.min(k, cnts.size());
        PriorityQueue<Map.Entry<String, Integer>> entries = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().intValue() == o1.getValue().intValue() ?
                        o1.getKey().compareTo(o2.getKey()) :
                        o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnts.entrySet()) {
            entries.offer(entry);
            if (entries.size() > k) {
                entries.poll();
            }
        }
        String[][] ret = new String[Math.min(cnts.size(), k)][2];
        while (!entries.isEmpty()) {
            Map.Entry<String, Integer> entry = entries.poll();
            ret[--k] = new String[]{entry.getKey(), String.valueOf(entry.getValue())};
        }
        return ret;
    }
}