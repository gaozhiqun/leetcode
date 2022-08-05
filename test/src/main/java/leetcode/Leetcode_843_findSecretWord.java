package leetcode;

import java.util.*;

public class Leetcode_843_findSecretWord {

    interface Master {
        public int guess(String word);
    }

    class MyMaster implements Master {

        String secret;

        MyMaster(String secret) {
            this.secret = secret;
        }

        @Override
        public int guess(String word) {
            int ans = 0;
            for (int k = 0; k < 6; k++) {
                if (secret.charAt(k) == word.charAt(k)) {
                    ans++;
                }
            }
            if (ans == 6) {
                System.out.println("找到了：" + secret);
            }
            return ans;
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {

        int n = wordlist.length;
        int[][] dis = new int[n + 1][n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
            for (int j = i + 1; j < n; j++) {
                dis[j][i] = getNum(wordlist, i, j);
                dis[i][j] = dis[j][i];
            }
        }
        for (int t = 0; t < 10; t++) {
            int max = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (set.contains(i)) {
                    int[] num = new int[7];
                    for (int j = 0; j < n; j++) {
                        if (i != j && set.contains(j)) {
                            num[dis[i][j]] += 1;
                        }
                    }
                    int tmp = getMax(num);
                    if (tmp < max) {
                        max = tmp;
                        index = i;
                    }
                }
            }
            int k = master.guess(wordlist[index]);
            set.remove(index);
            for (int j = 0; j < n; j++) {
                if (j == index) {
                    continue;
                }
                if (set.contains(j) && dis[index][j] < k) {
                    set.remove(j);
                }
            }
        }
    }

    private int getMax(int[] num) {
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            max = max < num[i] ? num[i] : max;
        }
        return max;
    }

    private int getNum(String[] wordlist, int i, int j) {
        int ans = 0;
        for (int k = 0; k < 6; k++) {
            if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
                ans++;
            }
        }
        return ans;
    }
}
