package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.modals.LoginToMoodPanda;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class MainPage extends BasePage {

    private static final String URL = "https://moodpanda.com";
    private static final String LOGIN = "//a[text()='Login']";

    @Step("Open 'Main Page'")
    public MainPage openMoodPanda() {
        open(URL);
        log.info("Open moodPanda using URL: " + URL);
        isMainPageOpened();
        return this;
    }

    @Step("Go to 'Login Page'")
    public LoginToMoodPanda clickLogin() {
        log.info("Click the button 'Login' " + " locator: " + LOGIN);
        $(By.xpath(LOGIN)).click();
        return new LoginToMoodPanda();
    }

    @Step("Validate that Main page was opened")
    public MainPage isMainPageOpened() {
        $(By.xpath(LOGIN)).shouldBe(Condition.visible);
        return this;
    }
}
