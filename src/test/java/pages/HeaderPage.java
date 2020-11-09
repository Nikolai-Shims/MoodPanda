package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.modals.RateHappiness;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
public class HeaderPage extends BasePage {

    private static final String LOGOUT = "LinkLogout";
    private static final String UPDATE_MOOD_BUTTON = ".navbar-hidesmalla";
    String dropDownMenu = "//span[contains(text(),'%s')]";
    String options = "//a[contains(text(),'%s')]";


    @Step("Choose drop down menu and click")
    public UpdatesPage chooseDropDown(String chooseDropDown, String option) {
        log.info("Choose drop down menu: " + chooseDropDown + ", and choose option: " + option);
        $(By.xpath(String.format(dropDownMenu, chooseDropDown))).click();
        $(By.xpath(String.format(options, option))).waitUntil(Condition.appear, basicTimeout).click();
        sleep(basicTimeout);
        return new UpdatesPage();
    }


    @Step("Should open 'Rate your Happiness' modal window")
    public RateHappiness shouldOpenRateHappinessModalWindow() {
        $(UPDATE_MOOD_BUTTON).click();
        return new RateHappiness();
    }


    @Step("Open drop down menu 'Account' and logout")
    public MainPage logout(String chooseDropDown) {
        log.info("Choose dropdown menu: " + chooseDropDown + " and logout");
        $(By.xpath(String.format(dropDownMenu, chooseDropDown))).click();
        $(By.id(LOGOUT)).waitUntil(Condition.appear, basicTimeout).click();
        return new MainPage();
    }

}
