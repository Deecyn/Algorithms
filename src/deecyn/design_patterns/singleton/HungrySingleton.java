package deecyn.design_patterns.singleton;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 单例设计模式 -- 饿汉式
 */
public class HungrySingleton {
    // 类加载时就初始化单例对象（也可以放在 static 代码块中进行初始化）
    private static final HungrySingleton  singleton = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
