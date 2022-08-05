package rateLimiterTest;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/26 下午1:31
 */
public class FakeServiceB extends FakeService{

    public FakeServiceB(String name) {
        super(name);
    }

    @Override
    void doSomething() {
        System.out.println("I am service B ");
    }
}
