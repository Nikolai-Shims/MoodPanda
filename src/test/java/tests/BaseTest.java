package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod
    public void before(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
}
