package algorithm.huawei;

import com.sun.javaws.security.AppContextUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午2:18
 */
public class RemoveList {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int total = sc.nextInt();
            int head = sc.nextInt();

            List<Integer> linkedlist = new ArrayList<>();

            linkedlist.add(head);
            for (int i = 0; i < total - 1; i ++) {
                int value = sc.nextInt();
                int target = sc.nextInt();
                linkedlist.add(linkedlist.indexOf(target) + 1, value);
            }

            int remove = sc.nextInt();
            linkedlist.remove(linkedlist.indexOf(remove));
            for (int i : linkedlist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
