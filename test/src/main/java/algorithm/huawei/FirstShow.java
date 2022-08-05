package algorithm.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午10:44
 */
public class FirstShow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        boolean[] seen = new boolean[26];
        Map<Character, Integer> posMap = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            if (seen[chars[i] - 'a']) {
                posMap.remove(chars[i]);
            } else {
                seen[chars[i] - 'a'] = true;
                posMap.put(chars[i], i);
            }
        }
        if (posMap.isEmpty()) {
            System.out.println(-1);
        }
        int min = Integer.MAX_VALUE;
        char ch = '0';
        for (Map.Entry<Character, Integer> entry : posMap.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                ch = entry.getKey();
            }
        }
        System.out.println(ch);


    }


}
