package mode.factroy.simplefactory.pizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.pizz
 * @filename: Pizz.java
 * @create: 2020/07/09 16:35
 * @author: 29314
 * @description: .披萨抽象类
 **/

public abstract class Pizz {
    String name;

    public abstract void make();

    public void cut(){
        System.out.println(name + "切片");
    }

    public void box(){
        System.out.println(name + "打包");
    }
}
