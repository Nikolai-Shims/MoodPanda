package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;


public class HomePageTest extends BaseTest {

    @Test(description = "Take a 'Hug' and validate counts", retryAnalyzer = Retry.class)
    @Description("Get count Hugs, click hug and validate that 'Hug' was left")
    @Issue("shim_nikolai")
    @Link("http://moodpanda.com")
    public void takeHug() {
        loginSteps
                .login(USERNAME, PASSWORD);
        homePageSteps
                .takeHug(0, "ButtonHug");

    }


    @Test(description = "Write comment and check that comment was written", retryAnalyzer = Retry.class)
    @Description("Get count comment, write comment and validate count it")
    @Issue("shim_nikolai")
    @Link("http://moodpanda.com")
    public void writeComment() {
        loginSteps
                .login(USERNAME, PASSWORD);
        homePageSteps
                .writeComment(0, "addcomment", "bad story");
    }


}
