package mode.factroy.simplefactory.pizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.pizz
 * @filename: BJAPizz.java
 * @create: 2020/07/09 16:39
 * @author: 29314
 * @description: .
 **/

public class BJAPizz extends Pizz{
    @Override
    public void make() {
        super.name = "北京A披萨";
        System.out.println(name + "制作。。。");
    }
}
