package deecyn.design_patterns.singleton;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 单例设计模式 -- 懒汉式
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
