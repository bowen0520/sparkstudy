package mode.factroy.simplefactory.store;

import mode.factroy.simplefactory.pizz.Pizz;

import java.util.Scanner;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.store
 * @filename: Order.java
 * @create: 2020/07/09 16:56
 * @author: 29314
 * @description: .
 **/

public class Order {

    public static void sale(Factroy<Pizz> factroy){
        do{
            System.out.println("输入pz类型:");
            String type = new Scanner(System.in).nextLine();
            Pizz pizz = factroy.producer(type);

            if(pizz == null){
                break;
            }

            pizz.make();
            pizz.cut();
            pizz.box();
        }while (true);
    }

    public static void main(String[] args) {
        sale(new BJPizzFactroy());
    }
}
