package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String LOGIN = "//a[text()='Login']";



    @Step("Open 'Main Page'")
    public MainPage openMoodPanda(){
        open("https://moodpanda.com/");
        return this;
    }

    @Step("Go to 'Login Page'")
    public void clickLogin(){
        $(By.xpath(LOGIN)).click();

    }
}
