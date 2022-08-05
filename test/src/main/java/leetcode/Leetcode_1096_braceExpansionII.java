package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 上午10:38
 */
public class Leetcode_1096_braceExpansionII {

    public static void main(String[] args) {
        Leetcode_1096_braceExpansionII l = new Leetcode_1096_braceExpansionII();
        //  System.out.println(l.braceExpansionII("{a,b}{c,{d,e}}"));
        System.out.println(l.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }


    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> ret = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        queue.offer(expression);
        while (!queue.isEmpty()) {
            String exp = queue.poll();
            if (exp.lastIndexOf('{') == -1) {
                ret.add(exp);
                continue;
            }
            int l = -1, r = -1;
            for (int i = 0; i < exp.length(); ++i) {
                if (exp.charAt(i) == '{') {
                    l = i;
                } else if (exp.charAt(i) == '}') {
                    r = i;
                    break;
                }
            }
            String before = exp.substring(0, l);
            String after = exp.substring(r + 1);
            String[] splits = exp.substring(l + 1, r).split(",");
            for (String s : splits) {
                builder.append(before).append(s).append(after);
                queue.offer(builder.toString());
                builder.setLength(0);
            }
        }


        List<String> ans = new ArrayList<>(ret);
        Collections.sort(ans);
        return ans;

    }

}
