package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.HomePage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertNotSame;

@Log4j2
public class HomePageSteps {

    HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @Step("Get count 'Hug', take 'Hug',then validate count")
    public HomePageSteps takeHug(int index, String text) {
        String countHugBeforeClick = homePage.getCountCommentOrHug(index, text);
        log.info("Count 'Hug' before click: " + countHugBeforeClick);
        homePage
                .takeHug(index);
        log.info("Take a 'Hug' on the " + index + " post");
        getWebDriver().navigate().refresh();
        String countAfterClick = homePage.getCountCommentOrHug(index, text);
        log.info("Count 'Hug' after click: " + countAfterClick);
        assertNotSame(countHugBeforeClick, countAfterClick);
        return this;
    }

    @Step("Get count 'Comment', write 'Comment',then validate count it")
    public HomePageSteps writeComment(int index, String text, String comment) {
        String countBefore = homePage.getCountCommentOrHug(index, text);
        log.info("Count 'Comment' before writing: " + countBefore);
        homePage
                .writeComment(index, comment);
        log.info("Take a 'Hug' on the " + index + " post");
        getWebDriver().navigate().refresh();
        String countAfter = homePage.getCountCommentOrHug(index, text);
        log.info("Count 'Comment' after wrote comment: " + comment);
        assertNotSame(countBefore, countAfter);
        return this;
    }
}
