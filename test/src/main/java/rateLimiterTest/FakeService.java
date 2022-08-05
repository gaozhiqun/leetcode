package rateLimiterTest;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/26 下午1:27
 */
public abstract class FakeService {

    private String name;

    protected LimitServiceManager limitServiceManager;

    public FakeService(String name) {
        this.name = name;
        this.limitServiceManager = LimitServiceManager.getInstance();
        limitServiceManager.registerService(name);
    }

    public void checkAndDo() {
        try {
            limitServiceManager.incrAndGet(name);
        } catch (Exception e) {
            System.out.println("Service +" + name + " Limited");
            return;
        }
        doSomething();
    }

    abstract void doSomething();

}
