package algorithm.huawei;


import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/24 下午6:35
 */
public class Trains {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int m = input.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = input.nextInt();
            }
            List<List<Integer>> ret = stack(arr, m);
            StringBuilder sb = new StringBuilder();
            List<String> result2 = new ArrayList<>();
            for (List<Integer> list : ret) {
                sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append(" ");
                    }
                }
                result2.add(sb.toString());
            }
            Collections.sort(result2);
            for (String s : result2) {
                System.out.println(s);
            }
        }

    }

    public static List<List<Integer>> stack(int[] arr, int m) {
        List<List<Integer>> ret = new ArrayList<>();
        recursive(ret, new LinkedList<>(), new Stack<>(), arr, 0, 0, m);
        return ret;
    }


    public static void recursive(List<List<Integer>> ret, LinkedList<Integer> temp,
                                 Stack<Integer> stack, int[] arr, int i, int j, int m) {
        if (i == m && j == m) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        if (j != m) {
            stack.push(arr[j]);
            recursive(ret, temp, stack, arr, i, j + 1, m);
            stack.pop();
        }
        if (!stack.isEmpty()) {
            int x = stack.pop();
            temp.add(x);
            recursive(ret, temp, stack, arr, i + 1, j, m);
            temp.remove(temp.size() - 1);
            stack.push(x);
        }
    }


}
