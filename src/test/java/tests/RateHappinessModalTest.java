package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;


public class RateHappinessModalTest extends BaseTest {

    @Test(description = "Create new 'Mood' and validate that mood was created", retryAnalyzer = Retry.class)
    @Description("Create new 'Mood' and validate that mood was created")
    @Issue("shim_nikolai")
    @Link("https://moodpanda.com/Feed/")
    public void createNewMood() {
        loginSteps
                .login(USERNAME, PASSWORD);
        updateMoodSteps
                .updateMood("bad story", 3);
    }

}
