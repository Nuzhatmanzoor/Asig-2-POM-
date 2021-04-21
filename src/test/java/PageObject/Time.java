package PageObject;

import base.GetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Time extends GetWebDriver {
    public void enter_date(String date) {

        driver.findElement(By.linkText("Time")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.linkText("My Records")).click();


        String[] splited_date_frm_dw = date.split("-");
        String year = splited_date_frm_dw[0];
        String month = splited_date_frm_dw[1];
        String day = splited_date_frm_dw[2];

        driver.findElement(By.id("attendance_date")).click();
        Select select_month1 = new Select(driver.findElement(By.className("ui-datepicker-month")));
        select_month1.selectByVisibleText(month);
        Select select_year1 = new Select(driver.findElement(By.className("ui-datepicker-year")));
        select_year1.selectByVisibleText(year);//*[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[4]/a
        String beforepath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
        String afterpath = "]/td[";
        boolean flag = false;
        final int total_no_of_days = 7;
        for (int row_no = 2; row_no <= 7; row_no++) {
            for (int col_no = 1; col_no <= total_no_of_days; col_no++) {
                String day_name = driver.findElement(By.xpath(beforepath + row_no + afterpath + col_no + "]")).getText();
                System.out.println(day_name);
                if (day_name.equals(day)) {
                    driver.findElement(By.xpath(beforepath + row_no + afterpath + col_no + "]")).click();
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        //   System.out.println(driver.findElement(By.xpath("//*[@id=\"noRecordsColumn\"]")).getText());
//*[@id="noRecordsColumn"]
    }
}
