package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/10 上午11:24
 */
public class Leetcode_406_reconstructQueue {
    public static void main(String[] args) {
        Leetcode_406_reconstructQueue l = new Leetcode_406_reconstructQueue();
        int[][] ans = l.reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
        System.out.println(ans);

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]);
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);

    }
}



