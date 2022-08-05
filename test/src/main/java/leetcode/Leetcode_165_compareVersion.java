package leetcode;


import java.util.Arrays;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/11/5 下午2:42
 */
public class Leetcode_165_compareVersion {

    public static void main(String[] args) {
        Leetcode_165_compareVersion l = new Leetcode_165_compareVersion();
        System.out.println(l.compareVersion("1.1", "1.10"));
        System.out.println(l.compareVersion("1.01", "1.001"));
        System.out.println(l.compareVersion("1.0", "1.0.0"));
        System.out.println(l.compareVersion("0.1", "1.1"));
        System.out.println(l.compareVersion("1.0.1", "1"));
    }


    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        int i = 0, j = 0, m = version1.length(), n = version2.length();
        while (i < m || j < n) {
            int a = 0, b = 0;
            StringBuilder aversion = new StringBuilder();
            StringBuilder bversion = new StringBuilder();
            boolean digitFound = false;
            while (i < m && version1.charAt(i) != '.') {
                if (digitFound || version1.charAt(i) != '0') {
                    digitFound = true;
                    aversion.append(version1.charAt(i));
                }
                ++i;
            }
            digitFound = false;
            while (j < n && version2.charAt(j) != '.') {
                if (digitFound || version2.charAt(j) != '0') {
                    digitFound = true;
                    bversion.append(version2.charAt(j));
                }
                ++j;
            }
            if (aversion.length() > 0) {
                a = Integer.parseInt(aversion.toString());
            }
            if (bversion.length() > 0) {
                b = Integer.parseInt(bversion.toString());
            }
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            ++i;
            ++j;
        }
        return 0;

    }


}