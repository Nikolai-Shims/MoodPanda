package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Login to Mood Panda")
    @Description("Open login page and field correct data")
    public void loginToMoodPanda(){
        loginPage
                .openloginPage()
                .loginToMoodPanda()
                .clickLogin();

    }
}
