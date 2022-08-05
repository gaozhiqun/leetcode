package algorithm.timer;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/22 2:16 下午
 */
public interface Timer {

    Timeout newTimeout(TimerTask task, long delay, TimeUnit unit, String argv);

    Set<Timeout> stop();
}
