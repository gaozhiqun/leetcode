package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/12/9 下午3:17
 */
public class Leetcode_390_lastRemaining {

    public int lastRemaining(int n) {
        return n==1 ? 1 : 2*(n/2+1-lastRemaining(n/2));
    }


}
