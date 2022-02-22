package mode.decorator.seasoning;

import mode.decorator.drink.Drink;

/**
 * @program: spark_test
 * @package: mode.decorator.seasoning
 * @filename: Decorator.java
 * @create: 2020/07/09 17:18
 * @author: 29314
 * @description: .
 **/

public class Decorator extends Drink {
    Drink drink;

    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + super.getPrice();
    }

    @Override
    public String getDescrip() {
        return drink.getDescrip()+"&&"+super.getDescrip();
    }

    @Override
    public String cost() {
        return this.getDescrip() + ":" + this.getPrice();
    }
}
