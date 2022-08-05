package algorithm.bfs;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/14 下午7:34
 */
public class PyramidTransition {
    public static void main(String[] args) {
        PyramidTransition p = new PyramidTransition();
        List<String> allowed = new ArrayList<>();
        allowed.add("BCG");
        allowed.add("CDE");
        allowed.add("GEA");
        allowed.add("FFF");
        System.out.println(p.pyramidTransition("BCD", allowed));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom.length() <= 1) {
            return true;
        }
        return recursive(bottom, 0, new StringBuilder(), buildDict(allowed));


    }

    private boolean recursive(String curBottom, int cur, StringBuilder stringBuilder, Map<String, List<String>> map) {
        if (curBottom.length() == 1) {
            return true;
        }
        if (cur == curBottom.length() - 1) {
            return recursive(stringBuilder.toString(), 0, new StringBuilder(), map);
        }
        String key = curBottom.substring(cur, cur + 2);
        List<String> nexts = map.get(key);
        if (Objects.isNull(nexts)) {
            return false;
        }
        for (String next : nexts) {
            stringBuilder.append(next);
            boolean result = recursive(curBottom, cur + 1, stringBuilder, map);
            if (result) {
                return result;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return false;
    }

    Map<String, List<String>> buildDict(List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            String value = s.substring(2);
            List<String> next = map.get(key);
            if (Objects.isNull(next)) {
                next = new ArrayList<>();
                map.put(key, next);
            }
            next.add(value);
        }
        return map;

    }


}
