package mode.decorator.seasoning;

import mode.decorator.drink.Drink;

/**
 * @program: spark_test
 * @package: mode.decorator.seasoning
 * @filename: Sugar.java
 * @create: 2020/07/09 17:24
 * @author: 29314
 * @description: .
 **/

public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        super.setDescrip("糖");
        super.setPrice(2.0);
    }
}
