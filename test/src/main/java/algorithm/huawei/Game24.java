package algorithm.huawei;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 下午8:23
 */
public class Game24 {
//    public static void main(String[] args) {
//        Game24 game24 = new Game24();
//        Scanner in = new Scanner(System.in);
//        int[] digits = new int[4];
//        for (int i = 0; i < 4; ++i) {
//            digits[i] = in.nextInt();
//        }
//        System.out.println(game24.backTrack(digits, 0));
//    }


    public boolean backTrack(int[] nums, int index) {
        if (index == 3) {
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int i = index; i < 4; i++) {
            swap(nums, index, i);
            if (backTrack(nums, index + 1)) {
                return true;
            }
            swap(nums, index, i);
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public boolean judge(double a, double b, double c, double d) {
        return judge(a + b, c, d) ||
                judge(a - b, c, d) ||
                judge(a * b, c, d) ||
                judge(a / b, c, d);
    }

    public boolean judge(double a, double b, double c) {
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b - a, c) ||
                judge(b / a, c) ||
                judge(a, b + c) ||
                judge(a, b - c) ||
                judge(a, b * c) ||
                judge(a, b / c);
    }

    public boolean judge(double a, double b) {
        return Math.abs(a + b - 24) < 0.001 ||
                Math.abs(a - b - 24) < 0.001 ||
                Math.abs(a * b - 24) < 0.001 ||
                Math.abs(a / b - 24) < 0.001 ||
                Math.abs(b - a - 24) < 0.001 ||
                Math.abs(b / a - 24) < 0.001;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        map.put("board delete", "no board at all");
        map.put("noMatch", "unknown command");
        Set<String[]> str = new HashSet<>();
        for (String s : map.keySet()
        ) {
            str.add(s.split(" "));
        }

        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s : str) {
                if (arr.length == 1) {
                    if (s.length == 2)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]))
                            res = s[0];
                    }
                }
                if (arr.length == 2) {
                    if (s.length == 1)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
                            res = s[0] + " " + s[1];
                            count++;
                        }
                    }
                }
            }
            System.out.println(count > 1 ? "unknown command" : map.get(res));
        }
    }
}
