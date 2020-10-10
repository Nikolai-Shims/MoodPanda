package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import tests.another.Retry;

public class HeaderTest extends BaseTest {

    @Test(description = "Login and logout", retryAnalyzer = Retry.class)
    @Description("Should do login and after logout")
    @Issue("shim_nikolai")
    @Link("http://moodpanda.com")
    public void shouldBeLogout() {
        loginSteps
                .login(USERNAME, PASSWORD);
        logoutSteps
                .logout();

    }
}
