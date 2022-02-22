package mode.factroy.simplefactory.store;

import mode.factroy.simplefactory.pizz.Pizz;
import mode.factroy.simplefactory.pizz.SHAPizz;
import mode.factroy.simplefactory.pizz.SHBPizz;

/**
 * @program: spark_test
 * @package: mode.factroy.simplefactory.store
 * @filename: SHPizzFactroy.java
 * @create: 2020/07/09 16:54
 * @author: 29314
 * @description: .
 **/

public class SHPizzFactroy implements Factroy<Pizz>{
    @Override
    public Pizz producer(String type) {
        Pizz p = null;

        if(type.equals("A")){
            p = new SHAPizz();
        }else if(type.equals("B")){
            p = new SHBPizz();
        }
        return p;
    }
}
