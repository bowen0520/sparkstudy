package mode.decorator.seasoning;

import mode.decorator.drink.Drink;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: spark_test
 * @package: mode.decorator.seasoning
 * @filename: Ice.java
 * @create: 2020/07/09 17:25
 * @author: 29314
 * @description: .
 **/

public class Ice extends Decorator {
    public Ice(Drink drink) {
        super(drink);
        super.setDescrip("冰块");
        super.setPrice(1.0);
    }
}
