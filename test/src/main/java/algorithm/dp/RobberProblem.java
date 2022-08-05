package algorithm.dp;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/3/25 3:30 下午
 */
public class RobberProblem {
    public static void main(String[] args) {

    }

    private int maxProfit(int[] a) {
        int[] dp = new int[a.length + 1];
        dp[0] = 0;
        dp[1] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + a[i], dp[i]);
        }
        return dp[a.length];
    }

    private int perfectSquares(int num) {
        int max = (int) Math.ceil(Math.sqrt(num));
        int[] multiple = new int[max + 1];
        multiple[0] = 1;
        int[] dp = new int[num + 1];
        for (int i = 1; i <= max; i++) {
            multiple[i] = i * i;
        }
        for (int i = 1; i <= num; i++) {
            dp[i] = i;
            for (int j = 1; j < multiple.length; j++) {
                if (i >= multiple[j]) {
                    dp[i] = Math.min(dp[i], dp[i - multiple[j]] + 1);
                }
            }
        }
        return dp[num];
    }

    private int maxLength(int[] nums) {
        return -1;
    }

    private int charges(int[] coins, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int c : coins) {
                if (i - c > 0 && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[k] == Integer.MAX_VALUE ? -1 : dp[k];
    }

    private List<Integer> longestIncrease(int[][] matrix) {
        //深度优先搜索
        return null;
    }

    private int convert(List<String> words, String from, String to) {
        Map<String, List<String>> neighbors = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.size(); i++) {
            for (int j = words.size() - 1; j > i; j--) {
            }
        }
        return -1;
    }

    private int dfs(String from, String to, Set<String> words) {
        return Integer.MAX_VALUE;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree[dest] += 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Check to see if topological sort is possible or not.
        if (i == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }


    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int n1[]=new int[n];
        int n2[]=new int[n];
        n1[0]=1;
        n2[0]=1;
        int[] result=new int[n];
        for(int i=1;i<n;i++){
            n1[i]=nums[i-1]*n1[i-1];
            n2[i]=nums[n-i]*n2[i-1];
        }
        for(int i=0;i<n;i++){
            result[i]=n1[i]*n2[n-i-1];
        }
        return result;
    }


}