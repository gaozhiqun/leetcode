package rateLimiterTest;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/26 下午1:30
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        FakeServiceA fakeServiceA = new FakeServiceA("fakeA");

        FakeServiceB fakeServiceB = new FakeServiceB("fakeB");

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; ++i) {
                    try {
                        Thread.sleep(10);
                        fakeServiceA.checkAndDo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; ++i) {
                    try {
                        Thread.sleep(10);
                        fakeServiceB.checkAndDo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread threadA = new Thread(runnableA);
        threadA.start();

        Thread threadB = new Thread(runnableB);
        threadB.start();

        threadA.join();
        threadB.join();
    }
}
