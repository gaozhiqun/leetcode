package leetcode;


import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_71_simplyPath {

    public static void main(String[] args) {
        Leetcode_71_simplyPath l = new Leetcode_71_simplyPath();
        System.out.println(l.simplifyPath("/home/"));
        System.out.println(l.simplifyPath("/../"));
        System.out.println(l.simplifyPath("/home//foo/"));
        System.out.println(l.simplifyPath("/a/./b/../../c/"));
        //System.out.println(l.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        //System.out.println(l.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));

    }

    public String simplifyPath(String path) {
        LinkedList<String> commands = new LinkedList<>();
        String[] cmds = path.split("/");
        for (String s : cmds) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (!commands.isEmpty()) {
                    commands.pollLast();
                }
            } else {
                commands.addLast(s);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String s : commands) {
            ans.append("/");
            ans.append(s);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }


}
