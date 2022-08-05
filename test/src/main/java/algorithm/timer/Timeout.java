package algorithm.timer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/22 2:17 下午
 */
public interface Timeout {
    Timer timer();
    TimerTask task();
    boolean isExpired();
    boolean isCancelled();
    boolean cancel();
}
