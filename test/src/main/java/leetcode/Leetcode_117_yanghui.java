package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_117_yanghui {
    public static void main(String[] args) {
        Leetcode_117_yanghui l = new Leetcode_117_yanghui();
        System.out.println(l.generate(5));
        System.out.println(l.getRow(5));
        System.out.println(l.generate(1));
        System.out.println(l.generate(2));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> seed = new ArrayList<>();
        seed.add(1);
        ans.add(seed);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> preList = ans.get(ans.size() - 1);
            list.add(1);
            int pre = preList.get(0);
            for (int j = 1; j < preList.size(); ++j) {
                int next = preList.get(j);
                list.add(pre + next);
                pre = next;
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1);
            int pre = preList.get(0);
            for (int j = 1; j < preList.size(); ++j) {
                int next = preList.get(j);
                newlist.add(pre + next);
                pre = next;
            }
            newlist.add(1);
            preList = newlist;
        }
        return preList;
    }


}
