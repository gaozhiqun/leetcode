package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_982_countTriplets {
    public static void main(String[] args) {
        Leetcode_982_countTriplets l = new Leetcode_982_countTriplets();


    }

    public int countTriplets(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int a : nums) {
            for (int b : nums) {
                int m = a & b;
                cnts.put(m, cnts.getOrDefault(m, 0) + 1);
            }
        }
        int ret = 0;
        for (int e : nums) {
            for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
                if ((e & entry.getKey()) == 0) {
                    ret += entry.getValue();
                }
            }
        }
        return ret;
    }

    public int countTriplets2(int[] A) {
        int k = 1;
        for (int item : A) {
            while (k <= item) {
                k <<= 1;
            }
        }
        int[] mem = new int[k];
        for (int item : A) {
            int mask = (k - 1) ^ item;
            int i = mask;
            while (true) {
                mem[i]++;
                if (i == 0) {
                    break;
                }
                i = (i - 1) & mask;
            }
        }
        int ans = 0;
        for (int a : A) {
            for (int b : A) {
                ans += mem[a & b];
            }
        }
        return ans;
    }
}
