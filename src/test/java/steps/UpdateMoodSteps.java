package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.HeaderPage;
import pages.UpdatesPage;


import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

@Log4j2
public class UpdateMoodSteps {

    HeaderPage headerPage;
    UpdatesPage updatesPage;

    public UpdateMoodSteps() {
        headerPage = new HeaderPage();
        updatesPage = new UpdatesPage();
    }

    @Step("Should be open modal window 'Update Mood' and update that")
    public void updateMood(String description, int slideSliderNumber) {
        headerPage
                .chooseDropDown("Me", "My updates");
        int amount = updatesPage.getCountOfPosts();
        log.info("Get count of posts before create: " + amount);
        headerPage
                .shouldOpenRateHappinessModalWindow()
                .isRateHappinessModalOpened()
                .moveSlider(slideSliderNumber)
                .descriptionMood(description)
                .shouldChooseDay()
                .confirmRateHappiness()
                .isMoodUpdatedModalOpened()
                .shouldOpenDairy();
        int amountAfterAddedPost = updatesPage.getCountOfPosts();
        log.info("Get count of posts after creating post: " + amountAfterAddedPost);
        assertEquals(amountAfterAddedPost, amount + 1);
        sleep(3000);
    }
}


