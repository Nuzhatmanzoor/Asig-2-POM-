package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass extends GetWebDriver {

    public BaseClass() throws IOException { //constructer

        Properties prop;
        prop = fileReader("\\src\\main\\resources\\Browsers.properties");

        String name = (prop.getProperty("Browser1"));
        System.out.println("Executing " + name + " Browser");
        if (name.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\broswerDrivers\\chromedriver.exe");
            driver = new ChromeDriver();


        } else if (name.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\broswerDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (name.equalsIgnoreCase("internet explorer")) {

            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\broswerDrivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

    public Properties fileReader(String filePath) throws IOException {

        File f1 = new File(System.getProperty("user.dir") + filePath);
        FileInputStream fileinput = null;
        fileinput = new FileInputStream(f1);
        Properties prop = new Properties();
        prop.load(fileinput);

        return prop;
    }
}
