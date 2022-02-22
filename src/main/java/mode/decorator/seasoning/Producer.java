package mode.decorator.seasoning;

import mode.decorator.drink.Coffee;
import mode.decorator.drink.Drink;

/**
 * @program: spark_test
 * @package: mode.decorator.seasoning
 * @filename: Producer.java
 * @create: 2020/07/09 17:28
 * @author: 29314
 * @description: .
 **/

public class Producer {
    public static void main(String[] args) {
        Drink d = new Coffee();

        System.out.println(d.cost());

        d = new Sugar(d);

        System.out.println(d.cost());

        d = new Ice(d);
        d = new Ice(d);

        System.out.println(d.cost());
    }
}
