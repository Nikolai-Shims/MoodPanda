package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class HomePage extends BasePage {

    private static final String ALL_POST = "//div[contains(@class,'rounded-top-corner')]";
    private static final String HUG = ".ButtonHug";
    private static final String COUNT_COMMENT_OR_HUG = "//*[contains(@class,'%s')]//span[2]";
    private static final String ADD_COMMENT = ".col-xs-4.addcomment";
    private static final String REPLY_BUTTON = "//*[contains(text(),'Reply')]";
    private static final String TEXT_AREA = "//div[contains(@class,'rounded-top-corner')]/following-sibling::div//textarea";

    @Step("Get count value 'Comment' or 'Hug'")
    public String getCountCommentOrHug(int index, String text) {
        log.info("Get count of things in: " + index + "post");
        ElementsCollection list = $$(By.xpath(ALL_POST));
        WebElement element = list.get(index);
        return element.findElement(By.xpath(String.format(COUNT_COMMENT_OR_HUG, text))).getText();
    }


    @Step("Get count of all post and Click Hug")
    public HomePage takeHug(int index) {
        log.info("Get all posts and click 'Hug' on " + index + " post");
        ElementsCollection list = $$(By.xpath(ALL_POST));
        list.get(index).$(HUG).waitUntil(Condition.appear, basicTimeout).click();
        return this;
    }

    @Step("Write comment after post")
    public HomePage writeComment(int index, String text) {
        ElementsCollection list = $$(By.xpath(ALL_POST));
        log.info("Get number of post: " + index + " and write a comment: " + text);
        list.get(index).$(ADD_COMMENT).waitUntil(Condition.appear, basicTimeout).click();
        $(By.xpath(TEXT_AREA)).waitUntil(Condition.appear, basicTimeout).sendKeys(text);
        $(By.xpath(REPLY_BUTTON)).waitUntil(Condition.appear, basicTimeout).click();
        return this;
    }

    @Step("Check that 'Home page' was opened")
    public HomePage isHomePageOpened() {
        $(By.xpath(ALL_POST)).shouldBe(Condition.visible);
        return this;
    }

}
