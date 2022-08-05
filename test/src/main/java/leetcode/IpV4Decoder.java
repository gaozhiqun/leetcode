package leetcode;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/8/4 下午9:15
 */
public class IpV4Decoder {


    public static long ipv4Devoder(String ip) {
        String[] digits = ip.split("\\.");

        if (digits.length != 4) {
            throw new IllegalArgumentException();
        }
        //
        long ret = 0L;
        for (String d : digits) {
            ret *= 256;
            ret += Integer.parseInt(d);
        }
        return ret;
    }

    public static long ipv4Devoder2(String ip) {
        long ret = 0;
        int digit = 0;
        for (int i = 0; i < ip.length(); ++i) {
            char ch = ip.charAt(i);
            if (Character.isDigit(ch)) {
                digit *= 10;
                digit += ch - '0';
            }
            if ('.' == ch || i == ip.length() - 1) {
                ret *= 256;
                ret += digit;
                digit = 0;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(ipv4Devoder2("192.168.1.1"));
        System.out.println(ipv4Devoder2("234.34.1.23"));
    }


}
