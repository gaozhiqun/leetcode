package leetcode;

import java.util.concurrent.Semaphore;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/27 下午3:06
 */
public class H2O {

    private Semaphore hSema = new Semaphore(2);
    private Semaphore oSema = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        releaseHydrogen.run();
        oSema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSema.acquire(2);
        releaseOxygen.run();
        hSema.release(2);
    }

}
