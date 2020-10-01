package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod
    public void before(ITestContext context){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
}
