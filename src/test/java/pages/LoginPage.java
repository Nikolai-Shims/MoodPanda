package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String URL = "https://moodpanda.com/Login/";
    private static final String USERNAME = "nikmoodpanda@mailinator.com";
    private static final String PASSWORDD = "1234qwer";
//    private static final String BUTTON_LOGIN = "ctl00$ContentPlaceHolderContent$ButtonLogin";
//    private static final String FIELD_PASSWORD = "ctl00$ContentPlaceHolderContent$TextBoxPassword";
//    private static final String FIELD_LOGIN = "ctl00$ContentPlaceHolderContent$TextBoxEmail";
public static final String FIELD_LOGIN = "//*[contains(text(),'email')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String FIELD_PASSWORD = "//*[contains(text(),'Password')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String BUTTON_LOGIN = "[value='Login']";

    @Step("Open Login Page")
    public LoginPage openloginPage(){
        open(URL);
        return this;
    }

    @Step("Fill 'Username' and 'Password'")
    public LoginPage loginToMoodPanda(){
        $(By.name(FIELD_PASSWORD)).sendKeys(PASSWORDD);
        $(By.name(FIELD_LOGIN)).sendKeys(USERNAME);
        return this;
    }

    @Step("Click button 'Login'")
    public HomePage clickLogin(){
        $(By.name(BUTTON_LOGIN)).click();
        return new HomePage();
    }


}
