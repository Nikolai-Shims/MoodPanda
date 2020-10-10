package pages.modals;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.BasePage;
import pages.UpdatesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MoodUpdated extends BasePage {

    private static final String DONE_BUTTON = "//button[contains(text(),'Done')]";
    private static final String OPEN_DAIRY_BUTTON = ".btn.btn-sm.btn-default.ButtonMyDiary.pull-left";

    @Step("Click button 'Open diary' and updates page should be open")
    public UpdatesPage shouldOpenDairy() {
        $(OPEN_DAIRY_BUTTON).click();
        sleep(3000);
        return new UpdatesPage();
    }

    @Step("Check that modal window 'Mood Updated' was opened")
    public MoodUpdated isMoodUpdatedModalOpened() {
        $(OPEN_DAIRY_BUTTON).shouldBe(Condition.visible);
        return this;
    }
}
