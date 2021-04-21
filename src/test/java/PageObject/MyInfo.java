package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyInfo extends GetWebDriver {

    public void navigate_Myinfo(String nick, String mil_ser, String bg, String com) {
        driver.findElement(By.linkText("My Info")).click();
        driver.findElement(By.id("btnSave")).click();//edit button
        driver.findElement(By.id("personal_txtEmpNickName")).sendKeys(nick);
        driver.findElement(By.id("personal_txtMilitarySer")).sendKeys(mil_ser);
        driver.findElement(By.id("personal_chkSmokeFlag")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.xpath("//*[@id=\"btnEditCustom\"]")).click();//blood group edit button
        Select drpdwn_bloodgrp = new Select(driver.findElement(By.name("custom1")));
        drpdwn_bloodgrp.selectByVisibleText(bg);//*[@id="frmEmpCustomFields"]/ol/li/select/option[2]
        driver.findElement(By.id("btnEditCustom")).click();//blood group button save
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAddAttachment")));
        driver.findElement(By.id("btnAddAttachment")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"ufile\"]"));
        upload_file.sendKeys(System.getProperty("user.dir") + "\\fileupload\\a.png");

        driver.findElement(By.id("txtAttDesc")).sendKeys(com);
        driver.findElement(By.id("btnSaveAttachment")).click();

    }
}
