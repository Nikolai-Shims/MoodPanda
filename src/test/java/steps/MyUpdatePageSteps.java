package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.UpdatesPage;

import static com.codeborne.selenide.Selenide.refresh;
import static org.testng.Assert.assertEquals;

@Log4j2
public class MyUpdatePageSteps {

    UpdatesPage updatesPage;

    public MyUpdatePageSteps() {
        updatesPage = new UpdatesPage();
    }

    @Step("Get count posts, delete post and validate count posts")
    public MyUpdatePageSteps deletePost(int index) {
        int count = updatesPage.getCountOfPosts();
        log.info("Count posts before deleting: " + count);
        updatesPage
                .deletePost(index);
        refresh();
        int countPostAfterDelete = updatesPage.getCountOfPosts();
        log.info("Count posts after deleting: " + countPostAfterDelete);
        assertEquals(countPostAfterDelete, count - 1);
        return this;
    }
}
