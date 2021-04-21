package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;

public class Login_Screen extends GetWebDriver {


    public void validCredentials(String Username, String Pass) throws InterruptedException {
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).sendKeys(Username);
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).sendKeys(Pass);
        driver.findElement(By.name("Submit")).click();

    }

    public void invalid_msg(String Username, String Pass) {
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).sendKeys(Username);
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).sendKeys(Pass);
        driver.findElement(By.name("Submit")).click();
        String invalid_credintial_msg = driver.findElement(By.id("spanMessage")).getText();
        System.out.println(invalid_credintial_msg + " Please try again");

    }

    public void openHomePage(String url) {

        driver.get(url);
    }
}
