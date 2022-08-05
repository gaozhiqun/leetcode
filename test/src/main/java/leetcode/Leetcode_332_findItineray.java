package leetcode;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/2 下午9:11
 */
public class Leetcode_332_findItineray {
    public static void main(String[] args) {
        /**
         * [1,2,31,33]
         * 2147483647
         * [["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],
         * ["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],
         * ["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
         *
         */
        Leetcode_332_findItineray l = new Leetcode_332_findItineray();


        List<List<String>> tickets = new ArrayList<>();
        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("A", "B"));
        tickets.add(Arrays.asList("A", "C"));
        tickets.add(Arrays.asList("B", "C"));
        tickets.add(Arrays.asList("B", "D"));
        System.out.println(l.findItinerary(tickets));

        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE", "AXA"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("ANU", "JFK"));
        tickets.add(Arrays.asList("JFK", "ANU"));
        tickets.add(Arrays.asList("ANU", "EZE"));
        tickets.add(Arrays.asList("TIA", "ANU"));
        tickets.add(Arrays.asList("AXA", "TIA"));
        tickets.add(Arrays.asList("TIA", "JFK"));
        tickets.add(Arrays.asList("ANU", "TIA"));
        tickets.add(Arrays.asList("JFK", "TIA"));
        System.out.println(l.findItinerary(tickets));

        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(l.findItinerary(tickets));

    }

    /**
     * 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
     * 输出：["JFK","MUC","LHR","SFO","SJC"]
     * 至少存在一种合理的行程,每张机票只能用一次
     * 欧拉回路：
     * 从起点出发，DFS，每次到另一个顶点就删除该边，没有可移动路径就开始返回
     * 经过所有的边恰好一次（可以理解为给定起点的「一笔画」问题），使得路径的字典序最小。
     */


    /**
     * 从起点出发，进行深度优先搜索。
     * <p>
     * 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。
     * <p>
     * 如果没有可移动的路径，则将所在节点加入到栈中，并返回。
     */

    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("A");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map.get(cur).poll());
        }
        itinerary.add(cur);
    }

}
