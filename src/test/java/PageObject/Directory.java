package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Directory extends GetWebDriver {
    public void search_directory(String name, String job_title, String location) {
        driver.findElement(By.linkText("Directory")).click();


        driver.findElement(By.xpath("//*[@id=\"searchDirectory_emp_name_empName\"]")).sendKeys(name);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"searchDirectory_emp_name_empName\"]")));
        List<WebElement> autoSuggest = driver.findElements(By.xpath("//*[@id=\"searchDirectory_emp_name_empName\"]"));
        for (WebElement a : autoSuggest) {
            // System.out.println("Values are = " + a.getText());
            if (a.getText().equalsIgnoreCase(name)) {
                a.click();
                break;
            }


        }
        WebDriverWait dropdowntitle = new WebDriverWait(driver, 20);
        dropdowntitle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='searchDirectory_job_title']//option[contains(text(),'QA Lead')]"))).click();

        WebDriverWait dropdownloc = new WebDriverWait(driver, 20);
        dropdownloc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='searchDirectory_location']//option[contains(text(),'Canada')]"))).click();
        driver.findElement(By.id("searchBtn")).click();

    }
}
