import PageObject.*;
import base.BaseClass;

import java.io.IOException;
import java.util.Properties;

public class TestBrowser extends ConfigReader {


    public static void main(String[] args) throws IOException, InterruptedException {
        BaseClass bsc = new BaseClass();
        Properties prop;

        prop = fileReader("\\src\\main\\resources\\TestData.properties");


        String user_name = (prop.getProperty("username"));
        String password = (prop.getProperty("password"));
        String url = (prop.getProperty("url"));
        String emp_name = prop.getProperty("emp_name");
        String username = prop.getProperty("user_name");
        String userrole = prop.getProperty("user_role");
        String status = prop.getProperty("status");
        //String emp_add= prop.getProperty("emp_name_toadd");
        String nick_name = prop.getProperty("nick_name");
        String mil_service = prop.getProperty("mil_service");
        String bgroup = prop.getProperty("blood_group");
        String com = prop.getProperty("comments");
        String dir_name = prop.getProperty("Directory_name");
        String job_title = prop.getProperty("Job_title");
        String location = prop.getProperty("Location");
        String date = prop.getProperty("Date");

        Login_Screen ls = new Login_Screen();
        ls.openHomePage(url);
        if (user_name.equals("Admin") && password.equals("admin123")) {
            ls.validCredentials(user_name, password);
            AdminPage_UserManagement ap = new AdminPage_UserManagement();
            ap.navigateToAdmin();
            ap.test_data(username, userrole, emp_name, status);
            MyInfo mi = new MyInfo();
            mi.navigate_Myinfo(nick_name, mil_service, bgroup, com);
            Directory d = new Directory();
            d.search_directory(dir_name, job_title, location);
            PIM p = new PIM();
            p.fcn_to_delete();
            Time t = new Time();
            t.enter_date(date);

        } else {
            ls.invalid_msg(user_name, password);
        }


    }

}

