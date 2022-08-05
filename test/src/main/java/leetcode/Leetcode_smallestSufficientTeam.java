package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午5:30
 */
public class Leetcode_smallestSufficientTeam {
    public static void main(String[] args) {
        Leetcode_smallestSufficientTeam l = new Leetcode_smallestSufficientTeam();
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList(new String[]{"java"}));
        people.add(Arrays.asList(new String[]{"nodejs"}));
        people.add(Arrays.asList(new String[]{"nodejs", "reactjs"}));
        System.out.println(l.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, people));
    }

    List<Integer> ret = null;
    Set<Integer> seen = null;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int total = req_skills.length;
        seen = new HashSet<>();
        Map<String, Integer> idxMap = new HashMap<>();
        int idx = 0;
        for (String skill : req_skills) {
            idxMap.put(skill, idx++);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> peoples = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            peoples.add(people.get(i).stream().map(o -> idxMap.get(o)).collect(Collectors.toList()));
            for (String s : people.get(i)) {
                List<Integer> cans = map.computeIfAbsent(idxMap.get(s), f -> new ArrayList<>());
                cans.add(i);
            }
        }
        bfs(0, 0, total, new HashSet<>(), map, peoples);
        int[] arr = new int[ret.size()];
        for (int i = 0; i < ret.size(); ++i) {
            arr[i] = ret.get(i);
        }
        return arr;
    }

    private void bfs(int cover, int peopleStatus, int total, Set<Integer> temp, Map<Integer, List<Integer>> map, List<List<Integer>> people) {
        int finalStatus = ((1 << total) - 1);
        if (cover == finalStatus) {
            if (ret == null || temp.size() < ret.size()) {
                ret = new ArrayList<>(temp);
            }
        }
        if (ret != null && temp.size() > ret.size()) {
            return;
        }
        for (int i = 0; i < total; ++i) {
            if ((cover & (1 << i)) != 0) {
                continue;
            }
            List<Integer> pList = map.get(i);
            for (int p : pList) {
                if (temp.contains(p)) {
                    continue;
                }
                temp.add(p);
                int nextCover = cover, nextPeopleStatus = peopleStatus;
                for (int skill : people.get(p)) {
                    nextCover = nextCover | (1 << skill);
                }
                nextPeopleStatus = nextPeopleStatus | (1 << p);
                if (!seen.contains(nextPeopleStatus)) {
                    seen.add(nextPeopleStatus);
                    bfs(nextCover, nextPeopleStatus, total, temp, map, people);
                }
                temp.remove(p);
            }
        }
    }

}
