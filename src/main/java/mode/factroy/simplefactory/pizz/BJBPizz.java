package mode.factroy.simplefactory.pizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.pizz
 * @filename: BJBPizz.java
 * @create: 2020/07/09 16:41
 * @author: 29314
 * @description: .
 **/

public class BJBPizz extends Pizz {
    @Override
    public void make() {
        super.name = "北京B披萨";
        System.out.println(name + "制作。。。");
    }
}
