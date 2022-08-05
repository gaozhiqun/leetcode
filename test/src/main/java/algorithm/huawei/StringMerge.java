package algorithm.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class StringMerge{
    public static void main(String[] str){
        processStr();
    }

    public static void processStr(){
        //hash 保存十六进制反转的对应表， 空间换时间
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('0', '0');
            put('1', '8');
            put('2', '4');
            put('3', 'C');
            put('4', '2');
            put('5', 'A');
            put('6', '6');
            put('7', 'E');
            put('8', '1');
            put('9', '9');
            put('a', '5');
            put('b', 'D');
            put('c', '3');
            put('d', 'B');
            put('e', '7');
            put('f', 'F');
            put('A', '5');
            put('B', 'D');
            put('C', '3');
            put('D', 'B');
            put('E', '7');
            put('F', 'F');
        }};

        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] ch = (s1 + s2).toCharArray();
            //偶数位
            char[]r1 = new char[ch.length / 2];
            //奇数位
            char[]r2 = new char[ch.length - ch.length / 2];
            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if ( i % 2 == 0){
                    r2[j] = ch[i];
                    j++;
                }else {
                    r1[k] = ch[i];
                    k++;
                }
            }

            Arrays.sort(r1);
            Arrays.sort(r2);

            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if (i % 2 == 0){
                    //注意存在码表不包含的情况，使用原值
                    ch[i] = map.getOrDefault(r2[j], r2[j]);
                    j++;
                }else {
                    ch[i] = map.getOrDefault(r1[k], r1[k]);
                    k++;
                }
            }

            s = new String(ch);
            System.out.println(s);

        }

        //return s;
    }
}
