package rateLimiterTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/26 下午1:08
 */
public class LimitServiceImpl implements LimitedService {


    private LinkedList<Node> list;
    private Map<Long, Node> map;
    int cntsTotal;
    int limit;
    String methodName;

    /**
     * @param limit
     */

    public LimitServiceImpl(int limit, String methodName) {
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.limit = limit;
        cntsTotal = 0;
        this.methodName = methodName;
    }


    @Override
    public void increAndGet() throws Exception {
        long startTime = System.currentTimeMillis() / 1000;

        while (!list.isEmpty() && list.peek().startTime - startTime > 5000) {
            Node pre = list.poll();
            cntsTotal -= pre.cnt;
            map.remove(pre.startTime);
        }
        Node node = map.get(startTime);
        if (node == null) {
            node = new Node(startTime);
            map.put(startTime, node);
            list.addLast(node);
        }
        node.cnt++;
        cntsTotal++;
        if (cntsTotal > limit) {
            cntsTotal--;
            throw new IllegalArgumentException("visit over limits");
        }
    }

    public static class Node {
        public long startTime;
        public int cnt;

        public Node(long startTime) {
            this.startTime = startTime;
            this.cnt = 0;
        }

    }

}
