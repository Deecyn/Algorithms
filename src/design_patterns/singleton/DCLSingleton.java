package design_patterns.singleton;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 单例设计模式 -- 双重检验锁模式（Double Check Lock）
 */
public class DCLSingleton {
    private static volatile DCLSingleton singleton;

    private DCLSingleton() {}

    public static DCLSingleton getInstance() {
        // Double Check Lock:
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
