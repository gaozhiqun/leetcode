package algorithm.huawei;

import java.util.Scanner;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/23 上午11:20
 */
public class SameSubnet {
    public static void main(String[] args) {
        /**
         *
         * 192.168.224.256
         *
         */
        System.out.println(compare("254.255.0.0", "85.122.52.249", "10.57.28.117"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String mask = scanner.nextLine();
            String ip0 = scanner.nextLine();
            String ip1 = scanner.nextLine();
            System.out.println(compare(mask, ip0, ip1));
        }
    }

    public static int compare(String mask, String ip0, String ip1) {
        if (!isValidIpv4(ip0) || !isValidIpv4(ip1) || !isValidMask(mask)) {
            return 1;
        }
        String[] segs0 = mask.split("\\.");
        String[] segs1 = ip0.split("\\.");
        String[] segs2 = ip1.split("\\.");
        for (int i = 0; i < 4; ++i) {
            int maskD = Integer.parseInt(segs0[i]);
            if (maskD == 0) {
                continue;
            }
            int a = Integer.parseInt(segs1[i]);
            int b = Integer.parseInt(segs2[i]);
            if ((a & maskD) != (b & maskD)) {
                return 2;
            }
        }
        return 0;
    }


    /**
     * 3行输入，第1行是输入子网掩码、第2，3行是输入两个ip地址
     */

    private static boolean isValidIpv4(String ip) {
        String[] segs = ip.split("\\.");
        if (segs.length != 4) {
            return false;
        }
        for (String s : segs) {

            if (s.startsWith("0") && !"0".equals(s)
                    ||s.contains("+")) {
                return false;
            }
            try {
                int n = Integer.parseInt(s.trim());
                if (n > 255 || n < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }


    private static boolean isValidMask(String mask) {
        String[] ss = mask.split("\\.");
        int[] m = new int[ss.length];
        for (int i = 0; i < ss.length; ++i) {
            m[i] = Integer.parseInt(ss[i]);
        }
        return m[0] >= 0 && m[0] <= 255 &&
                m[1] >= 0 && m[1] <= 255 &&
                m[2] >= 0 && m[2] <= 255 &&
                m[3] >= 0 && m[3] <= 255 &&
                m[0] >= m[1] && m[1] >= m[2] && m[2] >= m[3];
    }
}
