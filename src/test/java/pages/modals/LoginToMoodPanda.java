package pages.modals;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginToMoodPanda {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final String BUTTON_LOGIN = "ctl00$ContentPlaceHolderContent$ButtonLogin";
    private static final String FIELD_PASSWORD = "ctl00$ContentPlaceHolderContent$TextBoxPassword";
    private static final String FIELD_LOGIN = "ctl00$ContentPlaceHolderContent$TextBoxEmail";

    @Step("Open Login Page")
    public LoginToMoodPanda openloginPage() {
        log.info("Open login modal window");
        open(URL);
        isLoginToMoodPandaOpened();
        return this;
    }

    @Step("Fill 'Username' and 'Password'")
    public LoginToMoodPanda loginToMoodPanda(String username, String password) {
        log.info("Login to mood panda with Username: " + username + " and password: " + password);
        $(By.name(FIELD_LOGIN)).sendKeys(username);
        $(By.name(FIELD_PASSWORD)).sendKeys(password);
        return this;
    }

    @Step("Click button 'Login'")
    public HomePage clickLogin() {
        $(By.name(BUTTON_LOGIN)).click();
        return new HomePage();
    }

    @Step("Check that 'Login Modal' was opened")
    public LoginToMoodPanda isLoginToMoodPandaOpened() {
        $(By.name(BUTTON_LOGIN)).shouldBe(Condition.visible);
        return this;
    }
}
