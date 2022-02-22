package mode.factroy.simplefactory.store;

import mode.factroy.simplefactory.pizz.Pizz;
import mode.factroy.simplefactory.pizz.BJAPizz;
import mode.factroy.simplefactory.pizz.BJBPizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.store
 * @filename: BJPizzFactroy.java
 * @create: 2020/07/09 16:45
 * @author: 29314
 * @description: .
 **/

public class BJPizzFactroy implements Factroy<Pizz> {

    @Override
    public Pizz producer(String type) {
        Pizz p = null;
        if(type.equals("A")){
            p = new BJAPizz();
        }else if(type.equals("B")){
            p = new BJBPizz();
        }
        return p;
    }
}
