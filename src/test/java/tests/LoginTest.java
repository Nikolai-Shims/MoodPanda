package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;


public class LoginTest extends BaseTest {

    @Test(description = "Login to Mood Panda", retryAnalyzer = Retry.class)
    @Description("Open login page and field correct data")
    @Issue("shim_nikolai")
    @Link("https://moodpanda.com")
    public void loginToMoodPanda() {
        loginSteps
                .login(USERNAME, PASSWORD);
    }
}
