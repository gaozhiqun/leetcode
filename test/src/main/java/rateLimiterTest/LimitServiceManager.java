package rateLimiterTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/7/26 下午1:12
 */
public class LimitServiceManager {


    public static class HOLDER {
        public static LimitServiceManager instance = new LimitServiceManager();
    }

    public static LimitServiceManager getInstance() {
        return HOLDER.instance;
    }


    Map<String, LimitedService> serviceMap;

    public LimitServiceManager() {
        this.serviceMap = new HashMap<>();
    }

    public void registerService(String serviceName) {
        LimitedService limitedService = defaultLimitedService(serviceName);
        serviceMap.put(serviceName, limitedService);
    }


    public void incrAndGet(String methodName) throws Exception {
        LimitedService limitedService = serviceMap.computeIfAbsent(methodName, f -> defaultLimitedService(methodName));
        synchronized (limitedService) {
            limitedService.increAndGet();
        }
    }

    private LimitedService defaultLimitedService(String methodName) {
        return new LimitServiceImpl(10, methodName);
    }

}
