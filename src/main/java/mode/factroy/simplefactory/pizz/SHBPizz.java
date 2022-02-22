package mode.factroy.simplefactory.pizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.pizz
 * @filename: SHBPizz.java
 * @create: 2020/07/09 16:42
 * @author: 29314
 * @description: .
 **/

public class SHBPizz extends Pizz {
    @Override
    public void make() {
        super.name = "上海B披萨";
        System.out.println(name + "制作。。。");
    }
}
