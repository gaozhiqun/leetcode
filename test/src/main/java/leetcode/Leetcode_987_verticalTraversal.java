package leetcode;

import algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/31 下午4:55
 */
public class Leetcode_987_verticalTraversal {


    TreeMap<Integer, List<int[]>> treeMap;


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        treeMap = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> ret = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : treeMap.entrySet()) {
            entry.getValue().sort((a, b) -> {
                return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
            });
            List<Integer> list = entry.getValue().stream().map(o -> {
                return o[0];
            }).collect(Collectors.toList());
            ret.add(list);
        }
        return ret;
    }

    private void dfs(TreeNode cur, int op, int level) {
        if (cur == null) {
            return;
        }
        List<int[]> list = treeMap.computeIfAbsent(op, f -> new ArrayList<>());
        list.add(new int[]{cur.val, level});
        dfs(cur.left, op - 1, level + 1);
        dfs(cur.right, op + 1, level + 1);
    }
}
