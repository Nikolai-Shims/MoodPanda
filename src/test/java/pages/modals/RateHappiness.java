package pages.modals;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RateHappiness {

    private static final String CLOSE_MODAL = ".btn.btn-sm.btn-default.pull-left";
    private static final String UPDATE_MOOD = ".btn.btn-sm.btn-primary.ButtonUpdate";
    private static final String SLIDER_RATE = ".ui-slider-handle.ui-state-default.ui-corner-all";
    private static final String DESCRIPTION_AREA = "ctl00$TextBoxUpdateMoodTag";
    private static final String YESTERDAY_BUTTON = ".ResetYesterday.btn.btn-default.btn-sm";

    @Step("Write description mood in the text area")
    public RateHappiness descriptionMood(String descriptionText) {
        log.info("Write description: " + descriptionText);
        $(By.name(DESCRIPTION_AREA)).sendKeys(descriptionText);
        return this;
    }

    @Step("Should choose a day")
    public RateHappiness shouldChooseDay() {
        $(YESTERDAY_BUTTON).click();
        return this;
    }

    @Step("Confirm modal window 'Rate Your Happiness' and open 'Mood Updated' modal window ")
    public MoodUpdated confirmRateHappiness() {
        $(UPDATE_MOOD).click();
        return new MoodUpdated();
    }

    @Step("Move slider on the right side or left side")
    public RateHappiness moveSlider(int number) {

        if (number < 5) {
            for (int d = 5 - number; d < 5; d++) {
                log.info("Slider will be move on the left ");
                $(SLIDER_RATE).sendKeys(Keys.ARROW_LEFT);
            }
        } else {
            for (int s = number; s > 5; s--) {
                log.info("Slider will be move on the right ");
                $(SLIDER_RATE).sendKeys(Keys.ARROW_RIGHT);
            }
        }
        return this;
    }

    @Step("Check that 'Rate Happiness Modal was open'")
    public RateHappiness isRateHappinessModalOpened() {
        $(CLOSE_MODAL).shouldBe(Condition.visible);
        return this;
    }
}
