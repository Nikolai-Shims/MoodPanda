package steps;

import io.qameta.allure.Step;
import pages.HeaderPage;
import pages.MainPage;

public class LogoutSteps {
    HeaderPage headerPage;
    MainPage mainPage;

    public LogoutSteps() {
        headerPage = new HeaderPage();
        mainPage = new MainPage();
    }

    @Step("Choose drop down menu 'Account' and choose option 'Logout'")
    public MainPage logout() {
        headerPage
                .logout("Account")
                .isMainPageOpened();
        return new MainPage();
    }
}
