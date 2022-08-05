package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/1 下午7:35
 */
public class Leetcode_49_groupAnagrams {

    public static void main(String[] args) {
        Leetcode_49_groupAnagrams l = new Leetcode_49_groupAnagrams();
        System.out.println(l.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    /**
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i]
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            List<String> candidates = map.get(key);
            if (candidates == null) {
                candidates = new ArrayList<>();
                map.put(key, candidates);
            }
            candidates.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        int[] cnts = new int[26];
        for (char ch : s.toCharArray()) {
            cnts[ch - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            if (cnts[i] > 0) {
                stringBuilder.append((char) (i + 'a'));
                stringBuilder.append(cnts[i]);
            }
        }
        return stringBuilder.toString();
    }


}
