package mode.decorator.drink;

/**
 * @program: spark_test
 * @package: mode.decorator.drink
 * @filename: Drink.java
 * @create: 2020/07/09 17:05
 * @author: 29314
 * @description: .
 **/

public abstract class Drink {
    double price;
    String descrip;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public abstract String cost();
}
