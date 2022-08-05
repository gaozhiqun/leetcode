package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/22 下午3:36
 */
public class Leetcode_1178_findNumOfValidWords {

    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

            for (String word : words) {
                int mask = 0;
                for (int i = 0; i < word.length(); ++i) {
                    char ch = word.charAt(i);
                    mask |= (1 << (ch - 'a'));
                }
                if (Integer.bitCount(mask) <= 7) {
                    frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (String puzzle : puzzles) {
                int total = 0;
                int mask = 0;
                for (int i = 1; i < 7; ++i) {
                    mask |= (1 << (puzzle.charAt(i) - 'a'));
                }
                int subset = mask;
                do {
                    int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                    if (frequency.containsKey(s)) {
                        total += frequency.get(s);
                    }
                    subset = (subset - 1) & mask;
                } while (subset != mask);

                ans.add(total);
            }
            return ans;
        }
    }


    /**
     * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
     * <p>
     * 单词 word 中包含谜面 puzzle 的第一个字母。
     * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
     * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
     * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
     *
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (String s : words) {
            int mask = 0;
            for (char ch : s.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                freqMap.put(mask, freqMap.getOrDefault(mask, 0) + 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();

        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (char ch : puzzle.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (freqMap.containsKey(s)) {
                    total += freqMap.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            ans.add(total);
        }
        return ans;
    }
}