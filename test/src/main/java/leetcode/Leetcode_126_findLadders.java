package leetcode;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_126_findLadders {
    public static void main(String[] args) {
        Leetcode_126_findLadders l = new Leetcode_126_findLadders();
        System.out.println(l.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(l.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> nbMap = new HashMap<>();
        for (String word : wordList) {
            nbMap.put(word, new ArrayList<>());
        }
        if (!nbMap.containsKey(endWord)) {
            return new ArrayList<>();
        }
        for (int i = 0; i < wordList.size(); i++) {
            String s1 = wordList.get(i);
            if (isNeighbor(s1, beginWord)) {
                nbMap.get(s1).add(beginWord);
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                String s2 = wordList.get(j);
                if (beginWord.equals(s1) || beginWord.equals(s2)) {
                    continue;
                }
                if (isNeighbor(s1, s2)) {
                    nbMap.get(s1).add(s2);
                    nbMap.get(s2).add(s1);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> seed = new ArrayList<>();
        seed.add(endWord);
        queue.offer(seed);
        int minSize = Integer.MAX_VALUE;
        outter:
        while (!queue.isEmpty()) {
            List<String> combine = queue.poll();
            Set<String> combineSet = new HashSet<>(combine);
            String last = combine.get(0);
            for (String nb : nbMap.get(last)) {
                if (combineSet.contains(nb)) {
                    continue;
                }
                List<String> list = new ArrayList<>();
                list.add(nb);
                list.addAll(combine);
                if (list.size() > minSize) {
                    break outter;
                }
                if (beginWord.equals(nb)) {
                    minSize = list.size();
                    ans.add(list);
                } else {
                    queue.offer(list);
                }
            }
        }
        return ans;
    }

    private boolean isNeighbor(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++cnt;
            }
        }
        return cnt == 1;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWords = new HashSet<>(wordList);
        allWords.add(beginWord);
        if (!allWords.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> nbMap = new HashMap<>();
        for (String s1 : allWords) {
            nbMap.put(s1, new ArrayList<>());
            for (String s2 : allWords) {
                if (isNeighbor(s1, s2)) {
                    nbMap.get(s1).add(s2);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(endWord);
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int m = queue.size();
            for (int i = 0; i < m; ++i) {
                String cur = queue.poll();
                visited.add(cur);
                if (cur.equals(beginWord)) {
                    return ans;
                }
                for (String next : nbMap.get(cur)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;
    }





}
