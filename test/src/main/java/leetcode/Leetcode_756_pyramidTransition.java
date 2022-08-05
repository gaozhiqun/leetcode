package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/17 下午8:25
 */
public class Leetcode_756_pyramidTransition {

    public static void main(String[] args) {
        Leetcode_756_pyramidTransition l = new Leetcode_756_pyramidTransition();
        System.out.println(l.pyramidTransition("BCD", Arrays.asList("BCG", "CDE", "GEA", "FFF")));
        System.out.println(l.pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC")));
    }

    Map<String, String> transMap;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        transMap = new HashMap<>();
        for (String allow : allowed) {
            String key = allow.substring(0, 2);
            String value = allow.substring(2);
            transMap.put(key, value);
        }
        return dfs(bottom);
    }

    private boolean dfs(String status) {
        if (status.length() == 1) {
            return true;
        }
        List<String> nextStatus = new ArrayList<>();
        getNextStatus(nextStatus, status, new StringBuilder(), 0);
        for (String next : nextStatus) {
            if (dfs(next)) {
                return true;
            }
        }
        return false;

    }

    private void getNextStatus(List<String> nextStatus, String status, StringBuilder cur, int i) {
        if (i == status.length() - 1) {
            nextStatus.add(cur.toString());
            return;
        }
        String bo = status.substring(i, i + 2);
        if (!transMap.containsKey(bo)) {
            return;
        }
        cur.append(transMap.get(bo));
        getNextStatus(nextStatus, status, cur, i + 1);
        cur.deleteCharAt(cur.length() - 1);
    }


}