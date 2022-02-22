package mode.decorator.drink;

/**
 * @program: spark_test
 * @package: mode.decorator.drink
 * @filename: Milk.java
 * @create: 2020/07/09 17:16
 * @author: 29314
 * @description: .
 **/

public class Milk extends Drink {
    public Milk(){
        super.descrip = "牛奶";
        super.price = 5.0;
    }
    @Override
    public String cost() {
        return getDescrip() + ":" + getPrice();
    }
}
