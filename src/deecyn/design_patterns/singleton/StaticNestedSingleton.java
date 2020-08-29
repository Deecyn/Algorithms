package deecyn.design_patterns.singleton;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 单例设计模式 -- 静态内部类模式
 */
public class StaticNestedSingleton {
    private static class SingletonHolder {
        private static final StaticNestedSingleton singleton = new StaticNestedSingleton();
    }
    private StaticNestedSingleton() {}

    public static final StaticNestedSingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
