package segmentTree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/1 下午4:27
 */
public class LeeCoin2 {

    public static void main(String[] args) {
        LeeCoin2 l = new LeeCoin2();
        int[] ans = l.bonus(6, new int[][]{
                {1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}
        }, new int[][]{
                {1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}
        });
        for (int i : ans) {
            System.out.println(i);
        }
    }

    /**
     * 将所有人的编号映射到 [1, N][1,N] 的区间，其中负责人及其团队需要映射到一段连续的区间
     * 能通过负责人的编号获取得到其团队的区间 [l, r][l,r]。
     */
    long[] treeArr1;
    long[] treeArr2;
    int[] ind; // ind[i]记录标号为i（题目中给定的标号）的节点在treeArr对应的位置。
    // 使用邻接表表示树
    int[] firstChild; // 记录标号为i（题目中给定的标号）的节点的第一个儿子节点标号。
    int[] nextSibling; // 记录标号为i（题目中给定的标号）的节点的下一个兄弟节点标号。
    int[] offspring; // 记录标号为i（题目中给定的标号）的节点一共有多少后代。
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        treeArr1 = new long[n + 1];
        treeArr2 = new long[n + 1];
        ind = new int[n + 1];
        firstChild = new int[n + 1];
        nextSibling = new int[n + 1];
        offspring = new int[n + 1];
        int father, son, root = 1;
        for(int[] pair : leadership){// 创建邻接表
            father = pair[0];
            son = pair[1];
            nextSibling[son] = firstChild[father];
            firstChild[father] = son;
        }
        traverse(root, 0); // 遍历填充offspring数组和ind数组
        int node, index, val, l, r;
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] op : operations){
            node = op[1];
            index = ind[op[1]]; //求得题目中给定的标号在树状数组上对应的位置。
            if(op[0] == 3){
                l = index;
                r = index + offspring[node];
                list.add((int)((r * query(treeArr1, r) - query(treeArr2, r)
                        - (l - 1) * query(treeArr1, l - 1) + query(treeArr2, l - 1)) % 1000000007L));
            }else{// 区间修改
                val = op[2];
                //根据操作确定区间修改的范围
                if(op[0] == 1){
                    l = index;
                    r = index;
                }else{
                    l = index;
                    r = index + offspring[node];
                }
                update(treeArr1, l, val);
                if(r < n){
                    update(treeArr1, r + 1, -val);
                }
                update(treeArr2, l, val * (l - 1));
                if(r < n){
                    update(treeArr2, r + 1, -r * val);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public long lowbit(long index){
        return index & -index;
    }

    public void update(long[] treeArr, int index, int val){
        long len = treeArr.length;
        for(; index < len; index += lowbit(index)){
            treeArr[index] += val;
        }
    }

    public long query(long[] treeArr, int index){
        long len = treeArr.length;
        long res = 0;
        for(; index > 0; index -= lowbit(index)){
            res += treeArr[index];
        }
        return res;
    }


    public int traverse(int root, int num){ // 该方法会返回root为根节点的子树一共有多少个节点。num表示在刚进入方法时，先根遍历一共遍历了多少节点。
        num++;
        ind[root] = num; // root是先序遍历的第num个节点,对应与数组treeArr的索引num。
        for(int child = firstChild[root]; child != 0; child = nextSibling[child]){
            num += traverse(child, num);
        }
        offspring[root] = num - ind[root];
        return offspring[root] + 1;
    }

}