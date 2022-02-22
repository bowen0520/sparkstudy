package mode.factroy.simplefactory.store;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.store
 * @filename: Factroy.java
 * @create: 2020/07/09 16:43
 * @author: 29314
 * @description: .工厂抽象类
 **/

public abstract interface Factroy<T> {
    public abstract T producer(String type);
}
