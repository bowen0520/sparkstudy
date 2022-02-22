package mode.decorator.seasoning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;

/**
 * @program: spark_test
 * @package: mode.decorator.seasoning
 * @filename: SQLTest.java
 * @create: 2020/07/10 19:06
 * @author: 29314
 * @description: .
 **/

public class SQLTest {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\ideal-workplace\\spark_test\\src\\main\\java\\mode\\decorator\\seasoning\\Decorator.java");

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
