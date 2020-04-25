package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

    public String getData(String whichData){

        String path = "/Users/mzahita/Desktop/TechnoStudy/Maven Days/keywordDrivenFramework/src/test/resources/configuration.properties";

        String result = null;

        try {
            InputStream inputStream = new FileInputStream(path);
            Properties prop = new Properties();

            prop.load(inputStream);

            result = prop.getProperty(whichData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "as";
    }


}
