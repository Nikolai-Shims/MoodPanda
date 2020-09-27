package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Login to Mood Panda")
    @Description("Open login page and field correct data")
    @Issue("shim_nikolai")
    @Link("moodpanda.com")
    public void loginToMoodPanda(){
        loginPage
                .openloginPage()
                .loginToMoodPanda()
                .clickLogin();

    }
}
