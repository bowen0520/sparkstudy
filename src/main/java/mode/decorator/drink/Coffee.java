package mode.decorator.drink;

/**
 * @program: spark_test
 * @package: mode.decorator.drink
 * @filename: Coffee.java
 * @create: 2020/07/09 17:11
 * @author: 29314
 * @description: .
 **/

public class Coffee extends Drink{
    public Coffee(){
        super.descrip = "咖啡";
        super.price = 5.5;
    }

    @Override
    public String cost() {
        return getDescrip() + ":" + getPrice();
    }
}
