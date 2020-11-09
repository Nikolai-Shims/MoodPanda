package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;

public class UpdatesTest extends BaseTest {

    @Test(description = "Delete post and validate", retryAnalyzer = Retry.class)
    @Description("Create new post, validate that post was created and delete post plus validate that post was deleted")
    @Link("https://moodpanda.com/Feed/")
    @Issue("shim_nikolai")
    public void deletePosts() {
        loginSteps
                .login(USERNAME, PASSWORD);
        updateMoodSteps
                .updateMood("bad day",7);
        myUpdatePageSteps
                .deletePost(1);

    }

}
