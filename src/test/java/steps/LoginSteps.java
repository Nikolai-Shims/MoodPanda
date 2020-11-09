package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.HomePage;
import pages.modals.LoginToMoodPanda;

@Log4j2
public class LoginSteps {

    LoginToMoodPanda loginToMoodPanda;
    HomePage homePage;

    public LoginSteps() {
        loginToMoodPanda = new LoginToMoodPanda();
        homePage = new HomePage();
    }

    @Step("Open modal window and login to mood panda")
    public HomePage login(String username, String password) {
        log.info("Login with username: " + username + "and password " + password);
        loginToMoodPanda
                .openloginPage()
                .isLoginToMoodPandaOpened()
                .loginToMoodPanda(username, password)
                .clickLogin()
                .isHomePageOpened();
        return new HomePage();
    }
}
