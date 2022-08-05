package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/1/10 下午2:44
 */
public class Leetcode_691_minStickers {
    public static void main(String[] args) {

    }

    public static int minStickers(String[] stickers, String target) {
        if (existLetterNotInStickers(stickers, target)) {
            return -1;
        }
        int[][] stickerMap = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerMap[i][c - 'a']++;
            }
        }
        HashMap<String, Integer> memo = new HashMap<>();
        return minStickers(stickerMap, target, memo);
    }

    private static int minStickers(int[][] stickerMap, String target, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.length() == 0) {
            memo.put("", 0);
            return 0;
        }

        char[] targetLetters = target.toCharArray(); // target
        int[] targetWord = new int[26]; // 以字母频率方式表示target
        for (char c : targetLetters) {
            targetWord[c - 'a']++;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < stickerMap.length; i++) {
            int[] sticker = stickerMap[i]; // 决定使用i号贴纸
            if (notContainAnyLetter(sticker, targetLetters)) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                // 如果目标中包含这种字母，使用1张贴纸后，计算这种字母还剩多少个
                int restCount = targetWord[j];
                if (targetWord[j] != 0) {
                    restCount = targetWord[j] > sticker[j] ? targetWord[j] - sticker[j] : 0;
                }
                // 将字母频率转成String：将这种字母添加到StringBuilder
                for (int k = 0; k < restCount; k++) {
                    sb.append((char) (j + 'a'));
                }
            }
            String restTarget = sb.toString(); // 使用完第1张贴纸后，剩余目标
            int next = minStickers(stickerMap, restTarget, memo); // 【递归】后续需要的贴纸数量
            if (next != -1) {
                minCount = Math.min(minCount, next + 1);
            } // 后续过程有效，当前这种方案（使用i号贴纸作为第1张），是一种有效方案
        }

        int ans = minCount == Integer.MAX_VALUE ? -1 : minCount;
        memo.put(target, ans);
        return ans;
    }

    private static boolean notContainAnyLetter(int[] sticker, char[] target) {
        char toCheckLetter = target[0];
        return sticker[toCheckLetter - 'a'] == 0;
    }

    private static boolean existLetterNotInStickers(String[] stickers, String target) {
        int[] stickersLetters = new int[26];
        for (String sticker : stickers) {
            for (char letter : sticker.toCharArray()) {
                stickersLetters[letter - 'a']++;
            }
        }
        for (char letter : target.toCharArray()) {
            if (stickersLetters[letter - 'a'] == 0) {
                return true;
            }
        }
        return false;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return calImportance(map, id);
    }

    private int calImportance(Map<Integer, Employee> map, int id) {

        Employee e = map.get(id);
        if (e == null) {
            return 0;
        }
        int ret = e.importance;
        for (Integer s : e.subordinates) {
            ret += calImportance(map, s);
        }
        return ret;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;
}
