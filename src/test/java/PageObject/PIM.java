package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PIM extends GetWebDriver {
    public void fcn_to_delete() {
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Employee List")).click();
        //Locating element by id text and store in variable "Element"
        //WebElement Element = driver.findElement(By.id("btnDelete"));

        // Scrolling down the page till the element is found
        //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'David')]/parent::td//preceding-sibling::td//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Lisa')]/parent::td//preceding-sibling::td//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Cecil')]/parent::td//preceding-sibling::td//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Alice')]/parent::td//preceding-sibling::td//preceding-sibling::td//input[@name='chkSelectRow[]']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("btnDelete")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
}
