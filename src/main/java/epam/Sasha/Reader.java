package epam.Sasha;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Reader {

    static FileReader reader;
    static Properties p;

    static {
        try {
            reader=new FileReader("src/main/resources/testdata.properties");
            p=new Properties();
            p.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return p.getProperty(key);
    }

}

