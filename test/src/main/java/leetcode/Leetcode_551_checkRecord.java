package leetcode;


/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/14 上午10:48
 */
public class Leetcode_551_checkRecord {


    public static void main(String[] args) {
        Leetcode_551_checkRecord l = new Leetcode_551_checkRecord();
    }

    public boolean checkRecord(String s) {
        int absentCnt = 0, lateCnt = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'A':
                    absentCnt++;
                    if (absentCnt >= 2) {
                        return false;
                    }
                    lateCnt = 0;
                    break;
                case 'L':
                    ++lateCnt;
                    if (lateCnt >= 3) {
                        return false;
                    }
                    break;
                default:
                    lateCnt = 0;
            }
        }
        return true;
    }




}