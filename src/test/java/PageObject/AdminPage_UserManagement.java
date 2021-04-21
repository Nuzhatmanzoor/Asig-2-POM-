package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPage_UserManagement extends GetWebDriver {
    public void navigateToAdmin() throws InterruptedException {


        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.id("menu_admin_UserManagement")).click();
        driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void test_data(String username, String userrole, String empname, String status) throws InterruptedException {
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
        Select drpdwn = new Select(driver.findElement(By.id("searchSystemUser_userType")));
        drpdwn.selectByVisibleText(userrole);
        driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(empname);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"searchSystemUser_employeeName_empName\"]")));
        List<WebElement> autoSuggest = driver.findElements(By.xpath("//*[@id=\"searchSystemUser_employeeName_empName\"]"));
        for (WebElement a : autoSuggest) {
            // System.out.println("Values are = " + a.getText());
            if (a.getText().equalsIgnoreCase(empname)) {
                a.click();
                break;
            }


        }

        //   Select drpdwn1 = new Select(driver.findElement(By.id("searchSystemUser_status")));
        // drpdwn1.selectByVisibleText(status);

        WebDriverWait dropdown1 = new WebDriverWait(driver, 20);//selecting drpdown through xpath contains
        dropdown1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='searchSystemUser_status']//option[contains(text(),'Enabled')]"))).click();
        driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
        driver.findElement(By.id("btnAdd")).click();


    }
}
