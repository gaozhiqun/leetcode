package algorithm.huawei;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/22 下午10:55
 */
public class ScoreSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<String> priorityQueue;
        int n = Integer.parseInt(in.nextLine());
        int c = Integer.parseInt(in.nextLine());
        String[] strings = new String[n];
        Map<String, Integer> posMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String s = in.nextLine();
            strings[i] = s;
            posMap.put(s, i);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int score1 = Integer.parseInt(a.split(" ")[1]);
                int score2 = Integer.parseInt(b.split(" ")[1]);
                if (c == 1) {
                    return score1 == score2 ? posMap.get(a) - posMap.get(b) : score1 - score2;
                } else {
                    return score1 == score2 ? posMap.get(a) - posMap.get(b) : score2 - score1;
                }
            }
        });
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
