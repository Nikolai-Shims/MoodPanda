package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import pages.MainPage;
import org.testng.annotations.BeforeMethod;
import steps.*;
import tests.another.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    public static final String USERNAME = "nikmoodpanda@mailinator.com";
    public static final String PASSWORD = "1234qwer";

    MainPage mainPage;
    HomePageSteps homePageSteps;
    MyUpdatePageSteps myUpdatePageSteps;
    UpdateMoodSteps updateMoodSteps;
    LoginSteps loginSteps;
    LogoutSteps logoutSteps;


    @BeforeMethod
    public void before() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        //Configuration.clickViaJs = true;
        Configuration.startMaximized = true;

        homePageSteps = new HomePageSteps();
        updateMoodSteps = new UpdateMoodSteps();
        logoutSteps = new LogoutSteps();
        myUpdatePageSteps = new MyUpdatePageSteps();
        loginSteps = new LoginSteps();

        mainPage = new MainPage();

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        getWebDriver().quit();
    }
}
