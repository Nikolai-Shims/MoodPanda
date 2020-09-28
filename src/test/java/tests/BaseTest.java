package tests;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod
    public void before(ITestResult result){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
}
