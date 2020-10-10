package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;

public class MainPageTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Open 'Mood panda' main page and validate that page was opened")
    @Issue("shim_nikolai")
    @Link("http://moodpanda.com")
    public void validateThatLoginModalOpen() {
        mainPage
                .openMoodPanda()
                .isMainPageOpened()
                .clickLogin()
                .isLoginToMoodPandaOpened();
    }

}
