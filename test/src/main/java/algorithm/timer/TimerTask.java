package algorithm.timer;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/22 2:17 下午
 */
public interface TimerTask {
    void run(Timeout timeout, String argv) throws Exception;

}
